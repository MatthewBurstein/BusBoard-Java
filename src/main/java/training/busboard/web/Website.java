package training.busboard.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import training.busboard.ApiServices.*;
import training.busboard.Models.Bus;
import training.busboard.Models.PostcodeError;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class Website {

    Logger LOGGER = LogManager.getLogger("ControllerLogging");

    @RequestMapping("/")
    ModelAndView home() {
        return new ModelAndView("index");
    }

    @RequestMapping("/busInfo")
    ModelAndView busInfo(@RequestParam("postcode") String postcode) {
        ApiRequestManagerService apiService = new ApiRequestManagerService();
        List<Bus> buses = apiService.getBusStopInfo(postcode);
        if (buses != null) {
            return new ModelAndView("info", "busInfo", new BusInfo(postcode, buses));
        } else {
            return postcodeError(new PostcodeError(postcode));
        }
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Website.class, args);
    }

    @RequestMapping("/postcodeError")
    ModelAndView postcodeError(PostcodeError error) {
        return new ModelAndView("error", "postcodeError", error);
    }
}