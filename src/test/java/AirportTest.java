import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void cannotAddPlaneToHangarTwice() {
        glasgow.addPlaneToHangar(chopper);
        glasgow.addPlaneToHangar(chopper);
        assertEquals(1, glasgow.countPlanesInHangar());
    }

    @Test
    public void planesAreAddedToHangarInSortedAscendingOrder() {
        glasgow.addPlaneToHangar(airship);
        glasgow.addPlaneToHangar(chopper);
        glasgow.addPlaneToHangar(islandHopper);
        glasgow.addPlaneToHangar(jetPack);
        ArrayList<Plane> expectedHangar = new ArrayList<>(Arrays.asList(jetPack, chopper, islandHopper, airship));
        assertEquals(expectedHangar, glasgow.getHangar());
    }

    @Test
    public void planesAreAllAddedToHangarEvenIfTheyAreAddedInAscendingOrder() {
        glasgow.addPlaneToHangar(jetPack);
        glasgow.addPlaneToHangar(chopper);
        glasgow.addPlaneToHangar(islandHopper);
        glasgow.addPlaneToHangar(airship);
        ArrayList<Plane> expectedHangar = new ArrayList<>(Arrays.asList(jetPack, chopper, islandHopper, airship));
        assertEquals(expectedHangar, glasgow.getHangar());
    }

    @Test
    public void canRemovePlaneFromHangar() {
        glasgow.addPlaneToHangar(airship);
        Plane removedPlane = glasgow.removePlaneFromHangar(100);
        assertEquals(airship, removedPlane);
        assertEquals(0, glasgow.countPlanesInHangar());
    }

    @Test
    public void optimalPlaneIsRemovedFromHangarWhenCapacityMatchesFlightMaxPassengers() {
        glasgow.addPlaneToHangar(jetPack);
        glasgow.addPlaneToHangar(chopper);
        glasgow.addPlaneToHangar(islandHopper);
        glasgow.addPlaneToHangar(airship);
        Plane removedPlane = glasgow.removePlaneFromHangar(10);
        assertEquals(islandHopper, removedPlane);
        assertEquals(3, glasgow.countPlanesInHangar());
    }

    @Test
    public void optimalPlaneIsRemovedFromHangarWhenCapacityDoesNotMatchFlightMaxPassengers() {
        glasgow.addPlaneToHangar(jetPack);
        glasgow.addPlaneToHangar(chopper);
        glasgow.addPlaneToHangar(islandHopper);
        glasgow.addPlaneToHangar(airship);
        Plane removedPlane = glasgow.removePlaneFromHangar(8);
        assertEquals(islandHopper, removedPlane);
        assertEquals(3, glasgow.countPlanesInHangar());
    }

    @Test
    public void noPlaneIsRemovedWhenNoneHaveLargeEnoughCapacity() {
        glasgow.addPlaneToHangar(jetPack);
        glasgow.addPlaneToHangar(chopper);
        glasgow.addPlaneToHangar(islandHopper);
        Plane removedPlane = glasgow.removePlaneFromHangar(100);
        assertNull(removedPlane);
        assertEquals(3, glasgow.countPlanesInHangar());
    }

    @Test
    public void flightCanBeCreatedByAirportWithOptimumPlane() {
        glasgow.addPlaneToHangar(jetPack);
        glasgow.addPlaneToHangar(chopper);
        glasgow.addPlaneToHangar(islandHopper);
        Flight flight = glasgow.createFlight(101, DestinationType.CLOCKWISE_ROOF, 3,79.50);
        assertEquals(chopper, flight.getPlane());
        assertEquals(101, flight.getFlightNumber());
        assertEquals(DestinationType.CLOCKWISE_ROOF, flight.getDestination());
        assertEquals(3, flight.getMaxPassengers());
        assertEquals(79.50, flight.getTicketPrice(), 0.001);
        assertTrue(flight.isInProgress());
    }
}
