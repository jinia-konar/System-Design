package dtos;

import enums.VehicleType;
import service.ParkingSpotManager;

import java.util.function.Supplier;

public class Vehicle {
    private String vehicleId;
    private VehicleType vehicleType;

    public Vehicle(String vehicleId, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
