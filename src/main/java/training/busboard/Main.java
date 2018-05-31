package training.busboard;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface();
        ui.requestPostcode();
        String postcodeInput = scanner.nextLine();
        Postcode postcode = PostcodeApiService.request(postcodeInput);
        System.out.println(postcode);
        TflApiRequestService tflApiRequestService = new TflApiRequestService();
        List<StopPoint> stopPoints = tflApiRequestService.getNextNearestBuses(postcode.latitude, postcode.longitude);
        System.out.println(ResponseProcessor.getClosestTwoStopPointIds(stopPoints));
        List<Bus> buses = tflApiRequestService.getStopInformation("490008660N");
        System.out.println(buses);
    }

    // Sample Id = 490008660N
}	
