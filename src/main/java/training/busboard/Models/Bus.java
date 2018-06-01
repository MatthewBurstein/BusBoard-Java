package training.busboard.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Bus {

    public int timeToStation;
    public String destinationName;
    public String stationName;
    public String platformName;

    public Bus() {
    }

    public Bus(int timeToStation, String destinationName, String stationName, String platformName) {
        this.timeToStation = timeToStation;
        this.destinationName = destinationName;
        this.stationName = stationName;
        this.platformName = platformName;
    }

    public int getTimeToStation() {
        return timeToStation;
    }

    public String getMinutes() {

        return (timeToStation / 60) + "min ";
    }

    public String getStop() {
        return stationName + " " + platformName;
    }

}
