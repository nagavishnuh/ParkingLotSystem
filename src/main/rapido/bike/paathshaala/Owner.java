package bike.paathshaala;

import java.util.ArrayList;
import java.util.List;

public class Owner implements Observer{
    List<ParkingLot> parkingLots = new ArrayList<>();
    Attendant parkingLotAttendant = new Attendant();

    public void setParkingLots(ParkingLot parkingLots) {
        this.parkingLots.add(parkingLots);
    }

    @Override
    public void notifyParkingLotIsFull() {
        System.out.println("Put Full Sign Board");
    }

    @Override
    public void notifyParkingLotIsBackAvailable() {
        System.out.println("Remove Full Sign Board");
    }

    public void subscribeToAParkingLot(int num){
        this.parkingLots.get(num).attachAnObserver(this);
    }

    public void setAttendant(Attendant parkingAttendant) {
        this.parkingLotAttendant = parkingAttendant;
        this.parkingLotAttendant.setParkingLots(parkingLots);
    }
}
