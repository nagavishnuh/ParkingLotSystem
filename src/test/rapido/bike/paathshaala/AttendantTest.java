package bike.paathshaala;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AttendantTest {
    Owner owner;
    Vehicle myCar;
    Attendant parkingAttendant;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        myCar = new Vehicle();
        parkingAttendant = new Attendant();
    }

    @Test
    void attendantShouldParkTheCarWhenSlotsAreFree() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(3);
        owner.setParkingLots(parkingLot1);
        owner.setParkingLots(parkingLot2);
        owner.setAttendant(parkingAttendant);

        ParkingLot lotNumberOfTheCarParked = parkingAttendant.parkTheCar(myCar);

        assertNotNull(lotNumberOfTheCarParked);
    }

    @Test
    void attendantShouldNotParkTheCarWhenSlotsAreFull() {
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);
        owner.setParkingLots(parkingLot1);
        owner.setParkingLots(parkingLot2);
        owner.setAttendant(parkingAttendant);

        ParkingLot lotNumberOfTheCarParked = parkingAttendant.parkTheCar(myCar);

        assertNull(lotNumberOfTheCarParked);
    }

    @Test
    void attendantShouldUnParkTheCarWhenTheCarIsParked() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        owner.setParkingLots(parkingLot1);
        owner.setParkingLots(parkingLot2);
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
        owner.setParkingLots(parkingLot1);
        owner.setParkingLots(parkingLot2);
        owner.setAttendant(parkingAttendant);

        boolean didAttendantUnParkTheCar = parkingAttendant.unParkTheCar(myCar);

        assertFalse(didAttendantUnParkTheCar);
    }
}
