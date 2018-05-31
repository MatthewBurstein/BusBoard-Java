package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Bus {

    public int timeToStation;
    public String destinationName;

    public Bus() {
    }

    public int getTimeToStation() {
        return timeToStation;
    }

    public int getMinutes() {
        return timeToStation / 60;
    }

    @Override
    public String toString() {
        return destinationName + " " + getMinutes() + "mins";
    }
}
