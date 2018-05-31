package training.busboard;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;


public class PostcodeApiService {

    public static Postcode request(String postcode) {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        String uri = "https://api.postcodes.io/postcodes/" + postcode.replaceAll("\\s+","");
        return client.target(uri).request(MediaType.APPLICATION_JSON).get(PostcodeApiResponseService.class).getResult();
    }
}
