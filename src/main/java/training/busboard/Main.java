package training.busboard;

import training.busboard.ApiServices.PostcodeApiRequestService;
import training.busboard.ApiServices.ResponseProcessor;
import training.busboard.ApiServices.TflApiRequestService;
import training.busboard.Models.Bus;
import training.busboard.Models.Postcode;
import training.busboard.Models.StopPoint;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface();
        ResponseProcessor rp = new ResponseProcessor();
        TflApiRequestService tflApiRequestService = new TflApiRequestService();
        PostcodeApiRequestService postcodeApiRequestService= new PostcodeApiRequestService();
        ui.requestPostcode();
        String postcodeInput = scanner.nextLine();
        Postcode postcode = postcodeApiRequestService.request(postcodeInput);
        System.out.println(postcode);
        List<StopPoint> stopPoints = tflApiRequestService.getNearestStops(postcode.latitude, postcode.longitude);
        stopPoints = rp.getClosestTwoStopPointIds(stopPoints);
        List<Bus> buses = tflApiRequestService.getClosestStopPointBuses(stopPoints);
        System.out.println(buses);
    }
}	
