package training.busboard.ApiServices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import training.busboard.Models.StopPoint;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TflApiRadiusResponseService {

    private List<StopPoint> stopPoints;

    public List<StopPoint> getStopPoints() {
        return stopPoints;
    }
}
