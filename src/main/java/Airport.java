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


    public int countPlanesInHangar() {
        return hangar.size();
    }

    public void addPlaneToHangar(Plane plane) {
        
    }
}
