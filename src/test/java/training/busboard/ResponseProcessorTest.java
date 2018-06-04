package training.busboard;

import com.google.common.collect.Lists;
import org.junit.Test;
import training.busboard.Builders.BusBuilder;
import training.busboard.Builders.StopPointBuilder;
import training.busboard.Models.Bus;
import training.busboard.Models.StopPoint;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;


public class ResponseProcessorTest {

    ResponseProcessor rp = new ResponseProcessor();

    @Test
    public void getNextFiveBusesReturnsNextFiveBuses() {
        Bus bus1 = BusBuilder.buildWithTimeToStation(1);
        Bus bus2 = BusBuilder.buildWithTimeToStation(2);
        Bus bus3 = BusBuilder.buildWithTimeToStation(3);
        Bus bus4 = BusBuilder.buildWithTimeToStation(4);
        Bus bus5 = BusBuilder.buildWithTimeToStation(5);
        Bus bus6 = BusBuilder.buildWithTimeToStation(6);
        Bus bus7 = BusBuilder.buildWithTimeToStation(7);
        List<Bus> testList = Lists.newArrayList(bus1, bus3, bus5, bus7, bus2, bus4, bus6);
        List<Bus> expected = Lists.newArrayList(bus1, bus2, bus3, bus4, bus5);
        List<Bus> actual = rp.getNextFiveBuses(testList);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void getClosestTwoStopPointsReturnsClosestTwoStopPoints() {
        StopPoint sp1 = StopPointBuilder.buildWithDistance((float) 1.0);
        StopPoint sp2 = StopPointBuilder.buildWithDistance((float) 1.2);
        StopPoint sp3 = StopPointBuilder.buildWithDistance((float) 1.3);
        StopPoint sp4 = StopPointBuilder.buildWithDistance((float) 1.4);
        List<StopPoint> testList = Lists.newArrayList(sp1, sp3, sp4, sp2);
        List<StopPoint> expected = Lists.newArrayList(sp1, sp2);
        List<StopPoint> actual = rp.getClosestTwoStopPointIds(testList);
        assertArrayEquals(actual.toArray(), expected.toArray());
    }

}
