package service;

import dtos.Vehicle;
import strategies.FindParkingSpotStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManager {
    private final List<ParkingSpot> parkingSpotList;
    private final FindParkingSpotStrategy parkingSpotStrategy;

    protected ParkingSpotManager(List<ParkingSpot> parkingSpotList, FindParkingSpotStrategy parkingSpotStrategy) {
        this.parkingSpotList = parkingSpotList.isEmpty() ? new ArrayList<>() : parkingSpotList;
        this.parkingSpotStrategy = parkingSpotStrategy;
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        if (parkingSpot != null) {
            parkingSpotList.add(parkingSpot);
        }
    }

    public void removeParkingSpot(ParkingSpot parkingSpot) {
        if (parkingSpot != null) {
            parkingSpotList.remove(parkingSpot);
        }
    }

    public ParkingSpot findParkingSpot(int entryGateId) {
        if (parkingSpotStrategy != null) {
            return parkingSpotStrategy.findSpot(parkingSpotList, entryGateId);
        }
        throw new RuntimeException("No parkingSpotStrategy found");
    }

    public void updateParkingSpot(ParkingSpot parkingSpot, Vehicle vehicle, boolean remove) {
        if (remove) parkingSpot.removeVehicle();
        else parkingSpot.addVehicle(vehicle);
    }
}
