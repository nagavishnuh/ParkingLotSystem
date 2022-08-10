package bike.paathshaala;

public class SecurityPersonnal implements Observer {
    ParkingLot parkingLot;

    public void setParkingLot(ParkingLot parkingLot)
    {
        this.parkingLot = parkingLot;
    }

    @Override
    public void notifyParkingLotIsFull() {
        System.out.println("Redirect");
    }

    @Override
    public void notifyParkingLotIsBackAvailable() {

    }

    public void subscribeToAParkingLot() {
        this.parkingLot.attachAnObserver(this);
    }
}
