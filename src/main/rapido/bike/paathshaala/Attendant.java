package bike.paathshaala;

import java.util.List;

public class Attendant {

    public Boolean parkTheCar(Vehicle myCar, List<ParkingLot> parkingLot) {
        for (ParkingLot lot : parkingLot) {
            if(lot.park(myCar)) {
                return true;
            }
        }
        return false;
    }
}
