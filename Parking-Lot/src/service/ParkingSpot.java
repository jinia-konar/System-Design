package service;

import dtos.Vehicle;

import java.util.Random;
import java.util.UUID;

public class ParkingSpot {
    private int parkingSpotId;
    private int price;
    private boolean isEmpty;
    private Vehicle vehicle;

    public ParkingSpot(int parkingSpotId, int price) {
        this.parkingSpotId = parkingSpotId;
        this.price = price; //Default price
        this.isEmpty = true;
        this.vehicle = null;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = false;
        System.out.println("Vehicle: " + vehicle.getVehicleId() + " added to parkingSpot: " + parkingSpotId);
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isEmpty = true;
        System.out.println("Vehicle removed from parkingSpot: " + parkingSpotId);
    }

    public int getParkingSpotId() {
        return parkingSpotId;
    }

    public int getPrice() {
        return price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
