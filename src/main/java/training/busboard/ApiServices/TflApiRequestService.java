package training.busboard.ApiServices;

import org.glassfish.jersey.jackson.JacksonFeature;
import training.busboard.Models.Bus;
import training.busboard.Models.StopPoint;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class TflApiRequestService {

    private static String APP_ID_AND_KEY = "app_id=1134a3b4&app_key=6f4a38870add579a1dc48219346fa78f";

    public List<StopPoint> getNearestStops(float lat, float lon) {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        String uri = "https://api.tfl.gov.uk/StopPoint" + "?stopTypes=NaptanPublicBusCoachTram&radius=500&lat=" + lat + "&lon=" + lon + "&" + APP_ID_AND_KEY;
        TflApiRadiusResponseService response = client.target(uri).request(MediaType.APPLICATION_JSON).get(TflApiRadiusResponseService.class);
        return response.stopPoints;
    }

    public List<Bus> getClosestStopPointBuses(List<StopPoint> stopPoints) {
        List<Bus> buses = new ArrayList<Bus>();
        stopPoints.forEach(sp -> {
           buses.addAll(getStopInformation(sp.naptanId));
        });
        return buses;
    }

    private List<Bus> getStopInformation(String stopId) {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        String uri = "https://api.tfl.gov.uk/StopPoint/" + stopId +
                "/Arrivals?" + APP_ID_AND_KEY;
        return client.target(uri).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Bus>>() {});
    }
}
