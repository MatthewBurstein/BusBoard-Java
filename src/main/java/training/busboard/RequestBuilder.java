package training.busboard;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class RequestBuilder {

    public RequestBuilder() {

    }

    public void getStopInformation(String stopId) {
        ObjectMapper objectMapper = new ObjectMapper();
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        String uri = "https://api.tfl.gov.uk/StopPoint/" + stopId +
                "/Arrivals?app_id=1134a3b4&app_key=6f4a38870add579a1dc48219346fa78f";
        List<Bus> buses = client.target(uri).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Bus>>() {});
        System.out.println(buses);
    }
}
