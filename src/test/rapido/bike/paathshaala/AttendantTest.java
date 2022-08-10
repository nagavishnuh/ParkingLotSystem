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
        owner.setParkingLots(parkingLot1);
        owner.setParkingLots(parkingLot2);
        Attendant parkingAttendant = new Attendant();
        owner.setAttendant(parkingAttendant);
        Vehicle myCar = new Vehicle();

        ParkingLot lotNumberOfTheCarParked = parkingAttendant.parkTheCar(myCar);

        assertNotNull(lotNumberOfTheCarParked);
    }

    @Test
    void attendantShouldNotParkTheCarWhenSlotsAreFull() {
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);
        Owner owner = new Owner();
        owner.setParkingLots(parkingLot1);
        owner.setParkingLots(parkingLot2);
        Attendant parkingAttendant = new Attendant();
        owner.setAttendant(parkingAttendant);
        Vehicle myCar = new Vehicle();

        ParkingLot lotNumberOfTheCarParked = parkingAttendant.parkTheCar(myCar);

        assertNull(lotNumberOfTheCarParked);
    }

    @Test
    void attendantShouldUnParkTheCarWhenTheCarIsParked() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        Owner owner = new Owner();
        Vehicle myCar = new Vehicle();
        owner.setParkingLots(parkingLot1);
        owner.setParkingLots(parkingLot2);
        Attendant parkingAttendant = new Attendant();
        owner.setAttendant(parkingAttendant);

        ParkingLot lotNumberOfTheCarParked = parkingAttendant.parkTheCar(myCar);
        boolean didAttendantUnParkTheCar = parkingAttendant.unParkTheCar(myCar);

        assertNotNull(lotNumberOfTheCarParked);
        assertTrue(didAttendantUnParkTheCar);
    }

    @Test
    void attendantShouldNotUnParkTheCarIfCarWasNeverParked() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        Owner owner = new Owner();
        Vehicle myCar = new Vehicle();
        owner.setParkingLots(parkingLot1);
        owner.setParkingLots(parkingLot2);
        Attendant parkingAttendant = new Attendant();
        owner.setAttendant(parkingAttendant);

        boolean didAttendantUnParkTheCar = parkingAttendant.unParkTheCar(myCar);

        assertFalse(didAttendantUnParkTheCar);
    }
}
