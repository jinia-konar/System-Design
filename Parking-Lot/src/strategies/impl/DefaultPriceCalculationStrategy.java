package strategies.impl;

import strategies.PriceCalculationStrategy;

import java.time.LocalDateTime;

public class DefaultPriceCalculationStrategy implements PriceCalculationStrategy {

    private final int defaultPrice;

    public DefaultPriceCalculationStrategy() {
        defaultPrice = 10;
    }

    @Override
    public int calculatePrice(LocalDateTime time, int price) {
        return price + defaultPrice;
    }
}
