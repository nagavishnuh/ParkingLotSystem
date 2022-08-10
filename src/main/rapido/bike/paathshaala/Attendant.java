package bike.paathshaala;

import java.util.ArrayList;
import java.util.List;

public class Attendant {
    List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingLot parkTheCar(Vehicle myCar) {
        int indexOfLotToPark = getIndexOfLotToPark();
        if(parkingLots.get(indexOfLotToPark).park(myCar)){
            return parkingLots.get(indexOfLotToPark);
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

    private int getIndexOfLotToPark() {
        int maxAvailableSlot = 0;
        int indexOfLotToPark = 0;
        for (int index = 0; index < parkingLots.size(); index++) {
            int availableSlot = parkingLots.get(index).getAvailableSlot();
            if(availableSlot > maxAvailableSlot){
                indexOfLotToPark = index;
                maxAvailableSlot = availableSlot;
            }
        }
        return indexOfLotToPark;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
}
