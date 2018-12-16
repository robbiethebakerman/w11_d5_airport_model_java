import java.util.ArrayList;

public class Airport {
    private String airportCode;
    private double revenue;
    private ArrayList<Plane> hangar;
//    private ArrayList<Plane> repairHangar;
//    needed if function is added to move broken planes to be repaired

    public Airport(String airportCode) {
        this.airportCode = airportCode;
        this.revenue = 0.00;
        this.hangar = new ArrayList<>();
    }

    public ArrayList<Plane> getHangar() {
        return hangar;
    }

    public int countPlanesInHangar() {
        return hangar.size();
    }

    public void addPlaneToHangar(Plane plane) {
        if (hangar.isEmpty()) {
            hangar.add(plane);
        }
        if (!hangar.contains(plane)) {
            for (int i = 0; i < hangar.size(); i++) {
                if (hangar.get(i).getType().getCapacity() > plane.getType().getCapacity()) {
                    hangar.add(i, plane);
                    return;
                } else if (i == (hangar.size() - 1)) {
                    hangar.add(plane);
                    return;
                }
            }
        }
    }

    public Plane removePlaneFromHangar(int flightMaxPassengers) {
        for (int i = 0; i < hangar.size(); i++) {
            if (hangar.get(i).getType().getCapacity() >= flightMaxPassengers) {
                return hangar.remove(i);
            }
        }
        return null;
    }

    public Flight createFlight(int flightNumber, DestinationType destination, int maxPassengers, double ticketPrice) {
        Plane plane = removePlaneFromHangar(maxPassengers);
        Flight flight = new Flight(plane, flightNumber, destination, maxPassengers, ticketPrice);
        return flight;
    }
}

