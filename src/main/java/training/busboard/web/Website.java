package training.busboard.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import training.busboard.ApiServices.PostcodeApiRequestService;
import training.busboard.ApiServices.TflApiRequestService;
import training.busboard.Models.Bus;
import training.busboard.Models.Postcode;
import training.busboard.Models.StopPoint;
import training.busboard.ResponseProcessor;
import training.busboard.UserInterface;

import java.util.List;
import java.util.Scanner;

@Controller
@EnableAutoConfiguration
public class Website {

    @RequestMapping("/")
    ModelAndView home() {
        return new ModelAndView("index");
    }

    @RequestMapping("/busInfo")
    ModelAndView busInfo(@RequestParam("postcode") String postcode) {
        TflApiRequestService tflApiRequestService = new TflApiRequestService();
        PostcodeApiRequestService postcodeApiRequestService= new PostcodeApiRequestService();
        ResponseProcessor rp = new ResponseProcessor();
        Postcode postcodeObj = postcodeApiRequestService.request(postcode);
        List<StopPoint> stopPoints = tflApiRequestService.getNearestStops(postcodeObj.latitude, postcodeObj.longitude);
        stopPoints = rp.getClosestTwoStopPointIds(stopPoints);
        List<Bus> buses = tflApiRequestService.getClosestStopPointBuses(stopPoints);
        return new ModelAndView("info", "busInfo", new BusInfo(postcode, buses)) ;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Website.class, args);
    }

}