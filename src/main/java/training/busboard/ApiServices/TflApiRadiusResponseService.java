package training.busboard.ApiServices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import training.busboard.Models.StopPoint;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TflApiRadiusResponseService {

    private List<StopPoint> stopPoints;
    private int total;

    public int getTotal() {
        return total;
    }

    public List<StopPoint> getStopPoints() {
        return stopPoints;
    }
}
