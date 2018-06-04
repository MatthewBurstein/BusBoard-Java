package training.busboard.ApiServices;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import training.busboard.Models.Bus;
import training.busboard.Models.Postcode;
import training.busboard.Models.StopPoint;

import javax.ws.rs.NotFoundException;
import java.util.List;

public class ApiRequestManagerService {

    private static Logger LOGGER = LogManager.getLogger("ApiRequestManagerService");

    public List<Bus> getBusStopInfo(String postcode) {
        List<Bus> buses = null;
        try {
            TflApiRequestService tflApiRequestService = new TflApiRequestService();
            Postcode postcodeObj = new PostcodeApiRequestService().request(postcode);
            List<StopPoint> stopPoints = tflApiRequestService.getNearestStopPoints(postcodeObj.latitude, postcodeObj.longitude);
            stopPoints = new ResponseProcessor().getClosestTwoStopPointIds(stopPoints);
            buses = tflApiRequestService.getClosestStopPointBuses(stopPoints);
            LOGGER.log(Level.INFO, "Api Interaction successfull");
        } catch (NotFoundException e){
            LOGGER.log(Level.ERROR, "Api interaction failed for postcode: " + postcode + ": " + e.getStackTrace());
        }
        return buses;
    }


}
