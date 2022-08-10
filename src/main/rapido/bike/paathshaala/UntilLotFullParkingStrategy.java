package bike.paathshaala;

import java.util.List;

public class UntilLotFullParkingStrategy implements Strategy{
    @Override
    public ParkingLot getParkingLotNumberToPark(List<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            if(!parkingLot.checkIfParkingLotIsFull()){
                return parkingLot;
            }
        }
        return null;
    }
}
