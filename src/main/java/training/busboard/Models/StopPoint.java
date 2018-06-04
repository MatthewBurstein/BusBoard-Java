package training.busboard.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class StopPoint {

    public String naptanId;
    public float distance;

    public StopPoint() {
    }

    public StopPoint(String naptanId, float distance) {
        this.naptanId = naptanId;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "id: " + naptanId + " distance: " + distance;
    }
}
