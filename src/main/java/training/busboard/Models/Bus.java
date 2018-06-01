package training.busboard.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Bus {

    public int timeToStation;
    public String destinationName;
    public String stationName;
    public String lineName;
    public String platformName;

    public Bus() {
    }

    public Bus(int timeToStation, String destinationName, String stationName, String lineName, String platformName) {
        this.timeToStation = timeToStation;
        this.destinationName = destinationName;
        this.stationName = stationName;
        this.lineName = lineName;
        this.platformName = platformName;
    }

    public int getTimeToStation() {
        return timeToStation;
    }

    public int getMinutes() {
        return timeToStation / 60;
    }

    @Override
    public String toString() {
        String representation = "Destination: " + destinationName +
                "\nArriving: " + getMinutes() + "mins" +
                "\nStop: " + stationName + " " + platformName + "\n";
        return representation;
    }
}
