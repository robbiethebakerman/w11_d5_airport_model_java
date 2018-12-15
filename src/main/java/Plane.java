import java.util.ArrayList;

public class Plane {
    private PlaneType type;
    private AirlineType airline;
    private ArrayList<Passenger> passengers;

    public Plane(PlaneType type, AirlineType airline) {
        this.type = type;
        this.airline = airline;
        this.passengers = new ArrayList<>();
    }

    public int countPassengers() {
        return passengers.size();
    }

    public void addPassenger(Passenger passenger) {
        if (countPassengers() < type.getCapacity()) {
            passengers.add(passenger);
            passenger.setOnPlane(true);
        }
    }

    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
        passenger.setOnPlane(false);
    }

    public void clearPassengers() {
        for (Passenger passenger : passengers) {
            passenger.setOnPlane(false);
        }
        passengers.clear();
    }
}
