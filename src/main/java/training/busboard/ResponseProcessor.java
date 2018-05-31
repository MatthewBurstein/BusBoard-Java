package training.busboard;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ResponseProcessor {

    public List<Bus> getNextFiveBuses(List<Bus> buses) {
        buses.sort(Comparator.comparingInt(Bus::getTimeToStation));
        List<Bus> nextFiveBuses = buses.subList(0, 4);
        return buses;
    }


}
