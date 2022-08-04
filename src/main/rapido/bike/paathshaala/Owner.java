package bike.paathshaala;

import java.util.ArrayList;
import java.util.List;

public class Owner implements Observer{
    boolean isParkingLotFull ;
    List<ParkingLot> parkingLot = new ArrayList<>();
    Attendant parkingLotAttendant = new Attendant();

    public boolean checkIfParkingLotIsFull()
    {
        return isParkingLotFull;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot.add(parkingLot);
    }

    @Override
    public void notifyParkingLotIsFull() {
        isParkingLotFull = true;
        System.out.println("Put Full Sign Board");
    }

    @Override
    public void notifyParkingLotIsBackAvailable() {
        isParkingLotFull = false;
        System.out.println("Remove Full Sign Board");
    }

    public void subscribeToAParkingLot(int num){
        this.parkingLot.get(num).attachAnObserver(this);
    }

    public boolean checkIfParkingLotIsAvailable() {
        return !isParkingLotFull;
    }


    public Boolean instructAttendantToPark(Vehicle myCar) {
        return parkingLotAttendant.parkTheCar(myCar, parkingLot);
    }
}
