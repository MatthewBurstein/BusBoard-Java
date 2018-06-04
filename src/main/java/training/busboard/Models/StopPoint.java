package training.busboard.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class StopPoint {

    private final float distanceInMeters;
    public final String naptanId;

    @JsonCreator
    public StopPoint(@JsonProperty("naptanId") String naptanId,
                     @JsonProperty("distance") float distance) {
        this.naptanId = naptanId;
        this.distanceInMeters = distance;
    }

    public float getDistanceInMeters() {
        return distanceInMeters;
    }

    @Override
    public String toString() {
        return "id: " + naptanId + " distance: " + distanceInMeters;
    }
}
