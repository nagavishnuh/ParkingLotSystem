package bike.paathshaala;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ObserverTest {
    @Test
    void shouldNotifyOwnerWhenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        Owner ownerMock = Mockito.spy(Owner.class);
        ownerMock.setParkingLot(parkingLot);
        ownerMock.subscribeToAParkingLot(0);

        boolean isParked = parkingLot.park(new Vehicle());

        assertTrue(isParked);
        verify(ownerMock, times(1)).notifyParkingLotIsFull();
    }

    @Test
    void shouldNotNotifyOwnerWhenParkingLotIsFree() {
        ParkingLot parkingLot = new ParkingLot(2);
        Owner ownerMock = Mockito.spy(Owner.class);
        ownerMock.setParkingLot(parkingLot);
        ownerMock.subscribeToAParkingLot(0);

        boolean isParked = parkingLot.park(new Vehicle());

        assertTrue(isParked);
        verify(ownerMock, times(0)).notifyParkingLotIsFull();
    }

    @Test
    void shouldNotifySecurityPersonnalWhenLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        SecurityPersonnal securityPersonnalMock = Mockito.spy(SecurityPersonnal.class);
        securityPersonnalMock.setParkingLot(parkingLot);
        securityPersonnalMock.subscribeToAParkingLot();

        boolean isParked = parkingLot.park(new Vehicle());

        assertTrue(isParked);
        verify(securityPersonnalMock,times(1)).notifyParkingLotIsFull();
    }

    @Test
    void shouldNotNotifySecurityPersonnalWhenLotIsFree() {
        ParkingLot parkingLot = new ParkingLot(2);
        SecurityPersonnal securityPersonnalMock = Mockito.spy(SecurityPersonnal.class);
        securityPersonnalMock.setParkingLot(parkingLot);
        securityPersonnalMock.subscribeToAParkingLot();

        securityPersonnalMock.setParkingLot(parkingLot);
        securityPersonnalMock.subscribeToAParkingLot();

        boolean isParked = parkingLot.park(new Vehicle());

        assertTrue(isParked);
        verify(securityPersonnalMock,times(0)).notifyParkingLotIsFull();
    }
}
