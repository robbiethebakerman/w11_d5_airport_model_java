import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlaneTest {

    private Passenger robbie;
    private Passenger charlotte;
    private Plane chopper;
    private Plane jetPack;

    @Before
    public void before() {
        robbie = new Passenger();
        charlotte = new Passenger();
        chopper = new Plane(PlaneType.CHOPPER, AirlineType.ROBBIEJET);
        jetPack = new Plane(PlaneType.JET_PACK, AirlineType.WINGING_IT_AIRLINES);
    }

    @Test
    public void canCountPassengers() {
        assertEquals(0, chopper.countPassengers());
    }

    @Test
    public void canAddPassenger() {
        chopper.addPassenger(robbie);
        assertEquals(1, chopper.countPassengers());
        assertTrue(robbie.isOnPlane());
    }

    @Test
    public void cannotAddPassengerIfPlaneFull() {
        jetPack.addPassenger(robbie);
        jetPack.addPassenger(charlotte);
        assertEquals(1, jetPack.countPassengers());
        assertTrue(robbie.isOnPlane());
        assertFalse(charlotte.isOnPlane());
    }

    @Test
    public void canRemovePassenger() {
        chopper.addPassenger(robbie);
        assertTrue(robbie.isOnPlane());
        chopper.removePassenger(robbie);
        assertEquals(0, chopper.countPassengers());
        assertFalse(robbie.isOnPlane());
    }

    @Test
    public void cannotRemovePassengerIfPassengerNotPresent() {
        chopper.addPassenger(charlotte);
        assertTrue(charlotte.isOnPlane());
        chopper.removePassenger(robbie);
        assertEquals(1, chopper.countPassengers());
        assertTrue(charlotte.isOnPlane());
        assertFalse(robbie.isOnPlane());
    }

//    @Test
//    public void canClearPassengers() {
//
//    }

}
