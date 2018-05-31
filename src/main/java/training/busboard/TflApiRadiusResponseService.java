package training.busboard;

import com.fasterxml.classmate.GenericType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TflApiRadiusResponseService {

    public List<StopPoint> stopPoints;
    public int total;

}
