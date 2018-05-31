package training.busboard;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ResponseProcessor {

    public static List<Bus> getNextFiveBuses(List<Bus> buses) {
        buses.sort(Comparator.comparingInt(Bus::getTimeToStation));
        List<Bus> nextFiveBuses = buses.subList(0, 4);
        return buses;
    }

    public static List<StopPoint> getClosestTwoStopPointIds(List<StopPoint> stopPoints) {
        stopPoints.sort((sp1, sp2) -> Float.compare(sp1.distance, sp2.distance));
        System.out.println(stopPoints);
        return stopPoints;
    }


}
