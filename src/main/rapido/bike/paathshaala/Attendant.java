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

    public Boolean unParkTheCar(Vehicle myCar, List<ParkingLot> parkingLots) {
        for (ParkingLot lot : parkingLots) {
            if(lot.unPark(myCar)){
                return true;
            }
        }
        return false;
    }

    public int parkTheCarToMaintainEvenDistributionAmongParkingLots(Vehicle myCar, List<ParkingLot> parkingLots){
        int maxAvailableSlot = parkingLots.get(0).getAvailableSlot();
        int indexOfLotToPark = 0;

        for (int index = 0; index < parkingLots.size(); index++) {
            int availableSlot = parkingLots.get(index).getAvailableSlot();
            if(availableSlot >maxAvailableSlot){
                indexOfLotToPark = index;
                maxAvailableSlot = availableSlot;
            }
        }
        if(parkingLots.get(indexOfLotToPark).park(myCar)){
            return indexOfLotToPark+1;
        }
        return -1;
    }
}
