package enums;

import service.ParkingSpotManager;
import service.impl.FourWheelerParkingSpotManager;
import service.impl.TwoWheelerParkingSpotManager;

import java.util.function.Supplier;

public enum VehicleType {
    TwoWheeler(TwoWheelerParkingSpotManager::getInstance),
    FourWheeler(FourWheelerParkingSpotManager::getInstance);

    private final Supplier<ParkingSpotManager> parkingSpotManagerSupplier;

    VehicleType(Supplier<ParkingSpotManager> parkingSpotManagerSupplier) {
        this.parkingSpotManagerSupplier = parkingSpotManagerSupplier;
    }

    public ParkingSpotManager getParkingSpotManager() {
        return this.parkingSpotManagerSupplier.get();
    }
}
