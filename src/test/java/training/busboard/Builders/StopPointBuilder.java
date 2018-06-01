package training.busboard.Builders;

import training.busboard.Models.StopPoint;

public class StopPointBuilder {

    public static StopPoint buildWithDistance(float distance) {
        return new StopPoint("naptanId", distance);
    }
}
