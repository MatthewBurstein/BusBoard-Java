package training.busboard.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Postcode {

    public float latitude;
    public float longitude;
    public String postcode;

    @Override
    public String toString() {
        return postcode + ",  lat: " + latitude + ",  long: " + longitude;
    }
}
