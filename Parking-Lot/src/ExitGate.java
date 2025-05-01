import dtos.Ticket;
import enums.PaymentType;
import factories.ParkingSpotManagerFactory;
import factories.PaymentFactory;
import service.ParkingSpot;
import service.ParkingSpotManager;
import service.PaymentMethod;
import strategies.PriceCalculationStrategy;

import java.util.concurrent.ExecutionException;

public class ExitGate {

    private final ParkingSpotManagerFactory spotManagerFactory;
    private final PriceCalculationStrategy priceCalculationStrategy;
    private final PaymentFactory paymentFactory;

    public ExitGate(PriceCalculationStrategy priceCalculationStrategy) {
        this.spotManagerFactory = new ParkingSpotManagerFactory();
        this.priceCalculationStrategy = priceCalculationStrategy;
        this.paymentFactory = new PaymentFactory();
    }

    private int calculatePrice(Ticket ticket) {
        return priceCalculationStrategy.calculatePrice(ticket.getGenerationTime(), ticket.getParkingSpot().getPrice());
    }

    private void updateParkingSpot(ParkingSpot parkingSpot) {
        ParkingSpotManager parkingSpotManager = spotManagerFactory.findParkingSpotManager(parkingSpot.getVehicle().getVehicleType());
        parkingSpotManager.updateParkingSpot(parkingSpot, parkingSpot.getVehicle(), true);
    }

    public void processPayment(Ticket ticket, PaymentType paymentType) {
        if (ticket == null) {
            System.out.println("Can not process this ticket as this ticket does not exists");
        } else {
            try {
                int price = calculatePrice(ticket);
                PaymentMethod paymentMethod = paymentFactory.getPaymentMethod(paymentType);
                paymentMethod.processPayment(price);
                updateParkingSpot(ticket.getParkingSpot());
            } catch (Exception e) {
                System.out.println("Unable to process ticket: " + ticket);
            }
        }
    }
}
