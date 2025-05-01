import dtos.Ticket;
import dtos.Vehicle;
import enums.PaymentType;
import enums.VehicleType;
import service.ParkingSpotManager;
import service.impl.FourWheelerParkingSpot;
import service.impl.FourWheelerParkingSpotManager;
import service.impl.TwoWheelerParkingSpot;
import service.impl.TwoWheelerParkingSpotManager;
import strategies.impl.DefaultPriceCalculationStrategy;

import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("Parking Lot");

        //Create parking spots
        //2 wheeler
        ParkingSpotManager twoWheelerParkingSpotManager = TwoWheelerParkingSpotManager.getInstance();
        twoWheelerParkingSpotManager.addParkingSpot(new TwoWheelerParkingSpot(0));
        twoWheelerParkingSpotManager.addParkingSpot(new TwoWheelerParkingSpot(1));

        //4 wheeler
        ParkingSpotManager fourWheelerParkingSpotManager = FourWheelerParkingSpotManager.getInstance();
        fourWheelerParkingSpotManager.addParkingSpot(new FourWheelerParkingSpot(0));
        fourWheelerParkingSpotManager.addParkingSpot(new FourWheelerParkingSpot(1));

        EntryGate entryGate = new EntryGate(0);
        ExitGate exitGate = new ExitGate(new DefaultPriceCalculationStrategy());

        Ticket firstTicket = entryGate.generateTicket(new Vehicle("KA3708", VehicleType.TwoWheeler));
        Ticket secondTicket = entryGate.generateTicket(new Vehicle("KA3709", VehicleType.FourWheeler));
        Ticket thirdTicket = entryGate.generateTicket(new Vehicle("KA3710", VehicleType.TwoWheeler));

        exitGate.processPayment(firstTicket, PaymentType.UPI);
        Ticket fourthTicket = entryGate.generateTicket(new Vehicle("KA3709", VehicleType.FourWheeler));
        Ticket fifthTicket = entryGate.generateTicket(new Vehicle("KA3709", VehicleType.FourWheeler));

        exitGate.processPayment(secondTicket, PaymentType.UPI);
        exitGate.processPayment(thirdTicket, PaymentType.Card);
        exitGate.processPayment(fourthTicket, PaymentType.Card);
        exitGate.processPayment(fifthTicket, PaymentType.UPI);
    }
}