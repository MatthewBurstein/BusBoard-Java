package training.busboard.ApiServices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.jackson.JacksonFeature;
import training.busboard.Models.Bus;
import training.busboard.Models.StopPoint;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class TflApiRequestService {

    Logger LOGGER = LogManager.getLogger("TflApiLogger");

    private static String APP_ID_AND_KEY = "app_id=" + System.getenv("TFL_API_ID") + "&app_key=" + System.getenv("TFL_API_KEY");

    public List<StopPoint> getNearestStops (float lat, float lon) throws NotFoundException {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        String uri = "https://api.tfl.gov.uk/StopPoint" + "?stopTypes=NaptanPublicBusCoachTram&radius=500&lat=" + lat + "&lon=" + lon + "&" + APP_ID_AND_KEY;
        TflApiRadiusResponseService response = client.target(uri).request(MediaType.APPLICATION_JSON).get(TflApiRadiusResponseService.class);
        return response.stopPoints;
    }

    public List<Bus> getClosestStopPointBuses(List<StopPoint> stopPoints) {
        List<Bus> buses = new ArrayList<>();
        stopPoints.forEach(sp -> buses.addAll(getStopInformation(sp.naptanId)));
        return buses;
    }

    private List<Bus> getStopInformation(String stopId) {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        String uri = "https://api.tfl.gov.uk/StopPoint/" + stopId +
                "/Arrivals?" + APP_ID_AND_KEY;
        return client.target(uri).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Bus>>() {});
    }
}
