package strategies.impl;

import strategies.PriceCalculationStrategy;

import java.time.LocalDateTime;

public class HourlyPriceCalculationStrategy implements PriceCalculationStrategy {
    @Override
    public int calculatePrice(LocalDateTime time, int price) {
        return time.getHour() * price;
    }
}
