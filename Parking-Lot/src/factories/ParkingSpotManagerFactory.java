package factories;

import enums.VehicleType;
import service.ParkingSpotManager;
import strategies.FindParkingSpotStrategy;

public class ParkingSpotManagerFactory {
    public ParkingSpotManager findParkingSpotManager(VehicleType vehicleType) {
        if (vehicleType == null) {
            throw new IllegalArgumentException("No valid vehicle type found");
        }
        return vehicleType.getParkingSpotManager();
    }
}
