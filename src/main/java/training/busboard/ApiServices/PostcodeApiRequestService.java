package training.busboard.ApiServices;


import org.glassfish.jersey.jackson.JacksonFeature;
import training.busboard.Models.Postcode;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;


public class PostcodeApiRequestService {

    public Postcode request(String postcode) {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        String uri = "https://api.postcodes.io/postcodes/" + postcode.replaceAll("\\s+","");
        return client.target(uri).request(MediaType.APPLICATION_JSON).get(PostcodeApiResponseService.class).result;
    }
}
