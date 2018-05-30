package training.busboard;

public class Bus {

    private final String timeToStation;
    private final String destinationName;

    public Bus(String destinationName, String timeToStation) {
        this.destinationName = destinationName;
        this.timeToStation = timeToStation;
    }
}
