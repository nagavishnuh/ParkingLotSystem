package bike.paathshaala;

import java.util.ArrayList;
import java.util.List;

public class Attendant {
    List<ParkingLot> parkingLots = new ArrayList<>();
    Strategy parkingStrategy = new EvenlyDistributedParkingStrategy();

    public ParkingLot parkTheCar(Vehicle myCar) {
        ParkingLot lotToPark = parkingStrategy.getParkingLotNumberToPark(parkingLots);
        if(lotToPark.park(myCar)){
            return lotToPark;
        }
        return null;
    }

    public Boolean unParkTheCar(Vehicle myCar) {
        for (ParkingLot lot : parkingLots) {
            if(lot.unPark(myCar)){
                return true;
            }
        }
        return false;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public void setParkingStrategy(Strategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }
}
