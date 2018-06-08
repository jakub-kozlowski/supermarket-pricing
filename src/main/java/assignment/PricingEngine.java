package assignment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PricingEngine {
    private final PriceSource priceSource;

    public PricingEngine(PriceSource priceSource) {
        this.priceSource = priceSource;
    }

    public BigDecimal price(Basket basket) {
        BigDecimal perItemPrice = basket.getItems().stream()
                .filter(item -> item.getPricingType() == ItemPricingType.PRICING_PER_ITEM)
                .map(item -> priceSource.getPrice(item.getName()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal perWeightPrice = basket.getItems().stream()
                .filter(item -> item.getPricingType() == ItemPricingType.PRICING_PER_WEIGHT)
                .map(item -> priceSource.getPrice(item.getName()).multiply(item.getWeight()).setScale(2, RoundingMode.UP))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return perItemPrice.add(perWeightPrice);
    }
}
