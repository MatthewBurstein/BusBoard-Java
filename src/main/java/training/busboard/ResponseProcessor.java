package training.busboard;

import training.busboard.Models.Bus;
import training.busboard.Models.StopPoint;

import java.util.Comparator;
import java.util.List;

public class ResponseProcessor {

    public List<Bus> getNextFiveBuses(List<Bus> buses) {
        buses.sort(Comparator.comparingInt(Bus::getTimeToStation));
        return buses.subList(0, 5);
    }

    public List<StopPoint> getClosestTwoStopPointIds(List<StopPoint> stopPoints) {
        stopPoints.sort((sp1, sp2) -> Float.compare(sp1.distance, sp2.distance));
        return stopPoints.subList(0, 2);
    }

}
