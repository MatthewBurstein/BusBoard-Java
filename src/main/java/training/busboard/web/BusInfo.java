package training.busboard.web;

import training.busboard.Models.Bus;

import java.util.List;

public class BusInfo {
    private final String postcode;
    private final List<Bus> buses;

    public BusInfo(String postcode, List<Bus> buses) {

        this.buses = buses;
        this.postcode = postcode;
    }

    public List<Bus> getBuses() { return buses; }

    public String getPostcode() {
        return postcode;
    }
}