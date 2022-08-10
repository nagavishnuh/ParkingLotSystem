package bike.paathshaala;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class StrategyTest {
    List<ParkingLot> parkingLots;
    Attendant attendant;
    ParkingLot lot1,lot2,lot3;

    @BeforeEach
    void setUp() {
        parkingLots = new ArrayList<>();
        attendant = new Attendant();
        lot1 = new ParkingLot(3);
        lot2 = new ParkingLot(3);
        lot3 = new ParkingLot(3);
    }

    @Test
    void attendantShouldFollowEvenParkingStrategy() {
        parkingLots.add(lot1);
        parkingLots.add(lot2);
        parkingLots.add(lot3);
        attendant.setParkingLots(parkingLots);
        EvenlyDistributedParkingStrategy evenlyDistributedParkingStrategySpy = Mockito.spy(EvenlyDistributedParkingStrategy.class);
        attendant.setParkingStrategy(evenlyDistributedParkingStrategySpy);

        attendant.parkTheCar(new Vehicle());
        attendant.parkTheCar(new Vehicle());
        attendant.parkTheCar(new Vehicle());

        Mockito.verify(evenlyDistributedParkingStrategySpy,Mockito.times(3)).getParkingLotNumberToPark(parkingLots);
    }

    @Test
    void attendantShouldFollowUntilLotFullStrategy() {
        parkingLots.add(lot1);
        parkingLots.add(lot2);
        parkingLots.add(lot3);
        attendant.setParkingLots(parkingLots);
        UntilLotFullParkingStrategy untilLotFullParkingStrategySpy = Mockito.spy(UntilLotFullParkingStrategy.class);
        attendant.setParkingStrategy(untilLotFullParkingStrategySpy);

        attendant.parkTheCar(new Vehicle());
        attendant.parkTheCar(new Vehicle());
        attendant.parkTheCar(new Vehicle());

        Mockito.verify(untilLotFullParkingStrategySpy,Mockito.times(3)).getParkingLotNumberToPark(parkingLots);
    }
}
