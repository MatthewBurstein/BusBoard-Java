package training.busboard.ApiServices;

import org.glassfish.jersey.jackson.JacksonFeature;
import training.busboard.Models.Postcode;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;


public class PostcodeApiRequestService {

    public Postcode request(String postcode) throws NotFoundException{
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        String uri = "https://api.postcodes.io/postcodes/" + postcode.replaceAll("\\s+", "");
        Postcode postcodeObj = client.target(uri).request(MediaType.APPLICATION_JSON).get(PostcodeApiResponseService.class).result;
        return postcodeObj;
    }
}
