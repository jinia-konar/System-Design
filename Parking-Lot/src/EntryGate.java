import dtos.Ticket;
import dtos.Vehicle;
import factories.ParkingSpotManagerFactory;
import service.ParkingSpot;
import service.ParkingSpotManager;

import java.time.LocalDateTime;

public class EntryGate {
    private final int entryGateId;
    private final ParkingSpotManagerFactory parkingSpotManagerFactory;

    public EntryGate(int entryGateId) {
        this.entryGateId = entryGateId;
        this.parkingSpotManagerFactory = new ParkingSpotManagerFactory();
    }

    private ParkingSpot findParkingSpot(ParkingSpotManager parkingSpotManager) {
        return parkingSpotManager.findParkingSpot(entryGateId);
    }

    private void updateParkingSpot(ParkingSpot parkingSpot, ParkingSpotManager parkingSpotManager, Vehicle vehicle) {
        parkingSpotManager.updateParkingSpot(parkingSpot, vehicle, false);
    }

    public Ticket generateTicket(Vehicle vehicle) {
        try {
            ParkingSpotManager parkingSpotManager = parkingSpotManagerFactory.findParkingSpotManager(vehicle.getVehicleType());
            ParkingSpot parkingSpot = findParkingSpot(parkingSpotManager);
            updateParkingSpot(parkingSpot, parkingSpotManager, vehicle);
            return new Ticket(LocalDateTime.now(), vehicle, parkingSpot);
        } catch (Exception e) {
            System.out.println("Can not generate ticket for vehicle: " + vehicle.toString());
            return null;
        }
    }
}
