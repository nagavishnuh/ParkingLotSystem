package bike.paathshaala;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    int parkingSlotsAvailable;
    List<Vehicle> parkingSlots = new ArrayList<>();

    private List<Observer> observers = new ArrayList<Observer>();

    ParkingLot(int totalSlots)
    {
        this.parkingSlotsAvailable = totalSlots;
    }

    public void attachAnObserver(Observer observer){
        observers.add(observer);
    }

    public Boolean park(Vehicle vehicle){
        if(hasSlotToPark() && isCarNotParkedAlready(vehicle)) {
            parkingSlotsAvailable -= 1;
            parkingSlots.add(vehicle);
            if(parkingSlotsAvailable==0){
                notifyAllObserversLotIsFull();
            }
            return true;
        }

        return false;
    }

    private boolean hasSlotToPark() {
        return parkingSlotsAvailable > 0;
    }

    private boolean isCarNotParkedAlready(Vehicle vehicle) {
        return !parkingSlots.contains(vehicle);
    }

    public Boolean unPark(Vehicle vehicle){
        if(parkingSlots.contains(vehicle)){
            if(parkingSlotsAvailable==0){
                notifyAllObserversSlotsAreBackAvailable();
            }
            parkingSlotsAvailable += 1;
            parkingSlots.remove(vehicle);
            return true;
        }
        return false;
    }

    private void notifyAllObserversSlotsAreBackAvailable() {
        for (Observer observer : observers) {
            observer.notifyParkingLotIsBackAvailable();
        }
    }

    public void notifyAllObserversLotIsFull(){
        for (Observer observer : observers) {
            observer.notifyParkingLotIsFull();
        }
    }

    public Boolean checkIfParkingLotIsFull(){
        if(parkingSlotsAvailable==0){
            notifyAllObserversLotIsFull();
            return true;
        }
        return false;
    }

    public int getAvailableSlot() {
        return parkingSlotsAvailable;
    }
}
