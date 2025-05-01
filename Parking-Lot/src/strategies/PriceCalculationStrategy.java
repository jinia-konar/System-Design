package strategies;

import java.time.LocalDateTime;

public interface PriceCalculationStrategy {
    int calculatePrice(LocalDateTime time, int price);
}
