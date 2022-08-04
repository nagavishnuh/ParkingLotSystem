package bike.paathshaala;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObserverTest {
    @Test
    void shouldNotifyOwnerWhenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        Owner owner = new Owner();
        owner.setParkingLot(parkingLot);
        owner.subscribeToAParkingLot(0);

        boolean isParked = parkingLot.park(new Vehicle());

        assertTrue(isParked);
        assertTrue(owner.checkIfParkingLotIsFull());
    }

    @Test
    void shouldNotNotifyOwnerWhenParkingLotIsFree() {
        ParkingLot parkingLot = new ParkingLot(2);
        Owner owner = new Owner();
        owner.setParkingLot(parkingLot);
        owner.subscribeToAParkingLot(0);

        boolean isParked = parkingLot.park(new Vehicle());

        assertTrue(isParked);
        assertFalse(owner.checkIfParkingLotIsFull());
    }

    @Test
    void shouldNotifySecurityPersonnalWhenLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        SecurityPersonnal securityPersonnal = new SecurityPersonnal();
        securityPersonnal.setParkingLot(parkingLot);
        securityPersonnal.subscribeToAParkingLot();

        boolean isParked = parkingLot.park(new Vehicle());

        assertTrue(isParked);
        assertTrue(securityPersonnal.checkIfParkingLotIsFull());
    }

    @Test
    void shouldNotNotifySecurityPersonnalWhenLotIsFree() {
        ParkingLot parkingLot = new ParkingLot(2);
        SecurityPersonnal securityPersonnal = new SecurityPersonnal();
        securityPersonnal.setParkingLot(parkingLot);
        securityPersonnal.subscribeToAParkingLot();

        boolean isParked = parkingLot.park(new Vehicle());

        assertTrue(isParked);
        assertFalse(securityPersonnal.checkIfParkingLotIsFull());
    }

    @Test
    void shouldNotifyOwnerWhenSlotsAreBackAvailable() {
        ParkingLot parkingLot = new ParkingLot(1);
        Owner owner = new Owner();
        owner.setParkingLot(parkingLot);
        owner.subscribeToAParkingLot(0);
        Vehicle myCar = new Vehicle();

        boolean isParked = parkingLot.park(myCar);
        boolean notifiedOwnerWhenLotIsFull = owner.checkIfParkingLotIsFull();
        boolean isUnParked = parkingLot.unPark(myCar);
        boolean notifiedOwnerWhenLotIsBackAvailable = owner.checkIfParkingLotIsAvailable();

        assertTrue(isParked);
        assertTrue(notifiedOwnerWhenLotIsFull);
        assertTrue(isUnParked);
        assertTrue(notifiedOwnerWhenLotIsBackAvailable);
    }
}
