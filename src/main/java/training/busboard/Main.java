package training.busboard;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface();
        ui.requestStopId();
        String stopId = scanner.nextLine();
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.getStopInformation(stopId);
    }

    // Sample Id = 490008660N
}	
