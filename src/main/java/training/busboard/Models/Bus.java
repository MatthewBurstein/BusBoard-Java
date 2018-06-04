package training.busboard.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Bus {

    public int timeToStationInSeconds;
    public String destinationName;
    public String stationName;
    public String platformName;

    @JsonCreator
    public Bus(@JsonProperty("timeToStation") int timeToStation,
               @JsonProperty("destinationName") String destinationName,
               @JsonProperty("stationName") String stationName,
               @JsonProperty("platformName") String platformName) {
        this.timeToStationInSeconds = timeToStation;
        this.destinationName = destinationName;
        this.stationName = stationName;
        this.platformName = platformName;
    }

    public int getTimeToStation() {
        return timeToStationInSeconds;
    }

    public String getMinutes() {

        return (timeToStationInSeconds / 60) + "min ";
    }

    public String getStop() {
        return stationName + " " + platformName;
    }

}
