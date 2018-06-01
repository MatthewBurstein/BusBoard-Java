package training.busboard.ApiServices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import training.busboard.Models.Postcode;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PostcodeApiResponseService {

    public Postcode result;

}
