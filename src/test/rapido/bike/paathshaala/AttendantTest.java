package bike.paathshaala;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class AttendantTest {
    @Test
    void attendantShouldParkTheCarWhenSlotsAreFree() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(3);
        Owner owner = new Owner();
        owner.setParkingLot(parkingLot1);
        owner.setParkingLot(parkingLot2);
        Vehicle myCar = new Vehicle();

        Boolean didAttendantParkTheCar = owner.instructAttendantToPark(myCar);

        assertTrue(didAttendantParkTheCar);
    }

    @Test
    void attendantShouldNotParkTheCarWhenSlotsAreFull() {
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);
        Owner owner = new Owner();
        owner.setParkingLot(parkingLot1);
        owner.setParkingLot(parkingLot2);
        Vehicle myCar = new Vehicle();

        Boolean didAttendantParkTheCar = owner.instructAttendantToPark(myCar);

        assertFalse(didAttendantParkTheCar);
    }

    @Test
    void attendantShouldUnParkTheCarWhenTheCarIsParked() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        Owner owner = new Owner();
        Vehicle myCar = new Vehicle();
        owner.setParkingLot(parkingLot1);
        owner.setParkingLot(parkingLot2);

        Boolean didAttendantParkTheCar = owner.instructAttendantToPark(myCar);
        Boolean didAttendantUnParkTheCar = owner.instructAttendantToUnPark(myCar);

        assertTrue(didAttendantParkTheCar);
        assertTrue(didAttendantUnParkTheCar);
    }

    @Test
    void attendantShouldNotUnParkTheCarIfCarWasNeverParked() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        Owner owner = new Owner();
        Vehicle myCar = new Vehicle();
        owner.setParkingLot(parkingLot1);
        owner.setParkingLot(parkingLot2);

        Boolean didAttendantUnParkTheCar = owner.instructAttendantToUnPark(myCar);

        assertFalse(didAttendantUnParkTheCar);
    }

    @Test
    void shouldFollowEvenDistributionPatternWhileParkingCar() {
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(3));
        parkingLots.add(new ParkingLot(3));
        parkingLots.add(new ParkingLot(3));
        Attendant parkingLotAttendant = new Attendant();

        int isFirstCarParkedAtFirstLot = parkingLotAttendant.parkTheCarToMaintainEvenDistributionAmongParkingLots(new Vehicle(), parkingLots);
        int isSecondCarParkedAtSecondLot = parkingLotAttendant.parkTheCarToMaintainEvenDistributionAmongParkingLots(new Vehicle(), parkingLots);
        int isThirdCarParkedAtThirdLot = parkingLotAttendant.parkTheCarToMaintainEvenDistributionAmongParkingLots(new Vehicle(), parkingLots);

        assertEquals(1, isFirstCarParkedAtFirstLot);
        assertEquals(2, isSecondCarParkedAtSecondLot);
        assertEquals(3, isThirdCarParkedAtThirdLot);
    }
}
