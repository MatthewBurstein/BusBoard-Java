package training.busboard;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface();
        ui.requestStopId();
        String stopId = scanner.nextLine();
        RequestBuilder requestBuilder = new RequestBuilder();
        List<Bus> buses = requestBuilder.getStopInformation(stopId);
        ResponseProcessor responseProcessor = new ResponseProcessor();
        System.out.println(responseProcessor.getNextFiveBuses(buses));
    }

    // Sample Id = 490008660N
}	
