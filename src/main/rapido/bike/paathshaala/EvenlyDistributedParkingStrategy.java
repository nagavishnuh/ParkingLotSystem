package bike.paathshaala;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EvenlyDistributedParkingStrategy implements Strategy{
    @Override
    public ParkingLot getParkingLotNumberToPark(List<ParkingLot> parkingLots) {
        int maxAvailableSlot = 0;
        int indexOfLotToPark = 0;
        for (int index = 0; index < parkingLots.size(); index++) {
            int availableSlot = parkingLots.get(index).getAvailableSlot();
            if(availableSlot > maxAvailableSlot){
                indexOfLotToPark = index;
                maxAvailableSlot = availableSlot;
            }
        }
        return parkingLots.get(indexOfLotToPark);
    }
}
