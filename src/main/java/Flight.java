public class Flight {
    private Plane plane;
    private int flightNumber;
    private DestinationType destination;
    private int maxPassengers;
    private double ticketPrice;
    private boolean inProgress;

    public Flight(
            Plane plane,
            int flightNumber,
            DestinationType destination,
            int maxPassengers,
            double ticketPrice
    ) {
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.maxPassengers = maxPassengers;
        this.ticketPrice = ticketPrice;
        this.inProgress = true;
    }

    public Plane getPlane() {
        return plane;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public DestinationType getDestination() {
        return destination;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }
}
