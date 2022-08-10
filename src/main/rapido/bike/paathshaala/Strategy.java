package bike.paathshaala;

import java.util.List;

public interface Strategy {
    ParkingLot getParkingLotNumberToPark(List<ParkingLot> parkingLots);
}
