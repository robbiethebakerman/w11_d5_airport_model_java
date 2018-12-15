import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {
    private Passenger robbie;
    private Passenger charlotte;
    private Plane chopper;
    private Plane jetPack;
    private Plane airship;
    private Plane islandHopper;
    private Airport glasgow;

    @Before
    public void before() {
        robbie = new Passenger();
        charlotte = new Passenger();
        chopper = new Plane(PlaneType.CHOPPER, AirlineType.ROBBIEJET);
        jetPack = new Plane(PlaneType.JET_PACK, AirlineType.WINGING_IT_AIRLINES);
        airship = new Plane(PlaneType.AIRSHIP, AirlineType.GLASGOW_BUDGET_AIRLINES);
        islandHopper = new Plane(PlaneType.ISLAND_HOPPER, AirlineType.HIGHLAND_FLYERS);
        glasgow = new Airport("GLA");
    }

    @Test
    public void canCountPlanesInHangar() {
        assertEquals(0, glasgow.countPlanesInHangar());
    }

    @Test
    public void canAddPlaneToHangar() {
        glasgow.addPlaneToHangar(chopper);
        assertEquals(1, glasgow.countPlanesInHangar());
    }
}
