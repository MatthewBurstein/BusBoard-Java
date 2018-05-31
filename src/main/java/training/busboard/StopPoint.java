package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class StopPoint {

    public String naptanId;
    public float distance;

    @Override
    public String toString() {
        return "id: " + naptanId + " distance: " + distance + ",,,";
    }
}
