package bike.paathshaala;

import java.util.ArrayList;
import java.util.List;

public class Owner implements Observer{
    List<ParkingLot> parkingLot = new ArrayList<>();
    Attendant parkingLotAttendant = new Attendant();

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot.add(parkingLot);
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
        this.parkingLot.get(num).attachAnObserver(this);
    }

    public Boolean instructAttendantToPark(Vehicle myCar) {
        return parkingLotAttendant.parkTheCar(myCar, parkingLot);
    }

    public Boolean instructAttendantToUnPark(Vehicle myCar) {
        return parkingLotAttendant.unParkTheCar(myCar, parkingLot);
    }
}
