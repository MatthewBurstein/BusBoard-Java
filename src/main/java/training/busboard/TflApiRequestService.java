package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class TflApiRequestService {

    private static String APP_ID_AND_KEY = "app_id=1134a3b4&app_key=6f4a38870add579a1dc48219346fa78f";

    public List<Bus> getStopInformation(String stopId) {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        String uri = "https://api.tfl.gov.uk/StopPoint/" + stopId +
                "/Arrivals?" + APP_ID_AND_KEY;
        return client.target(uri).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Bus>>() {});
    }

    public List<StopPoint> getNextNearestBuses(float lat, float lon) {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        String uri = "https://api.tfl.gov.uk/StopPoint" + "?stopTypes=NaptanPublicBusCoachTram&radius=500&lat=" + lat + "&lon=" + lon + "&" + APP_ID_AND_KEY;
        TflApiRadiusResponseService res = client.target(uri).request(MediaType.APPLICATION_JSON).get(TflApiRadiusResponseService.class);
        System.out.println(res);
        System.out.println(res.total);
        return res.stopPoints;
    }
}
