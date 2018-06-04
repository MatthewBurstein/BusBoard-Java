package training.busboard.Builders;

import training.busboard.Models.Bus;

public class BusBuilder {

        public static Bus buildWithTimeToStation(int timeToStation) {
            return new Bus(timeToStation, "destination", "stationName", "platformName");
        }

}
