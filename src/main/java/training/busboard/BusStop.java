package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BusStop {

    public String naptanId;
    public String fullName;

    @Override
    public String toString() {
        return fullName + " " +naptanId;
    }
}
