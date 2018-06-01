package training.busboard.ApiServices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import training.busboard.Models.StopPoint;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TflApiRadiusResponseService {

    public List<StopPoint> stopPoints;
    public int total;

}
