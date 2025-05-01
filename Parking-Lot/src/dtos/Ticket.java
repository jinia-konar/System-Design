package dtos;

import service.ParkingSpot;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private int ticketId;
    private LocalDateTime generationTime;
    Vehicle vehicle;
    ParkingSpot parkingSpot;

    public Ticket(LocalDateTime generationTime, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = UUID.randomUUID().hashCode();
        this.generationTime = generationTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public int getTicketId() {
        return ticketId;
    }

    public LocalDateTime getGenerationTime() {
        return generationTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
