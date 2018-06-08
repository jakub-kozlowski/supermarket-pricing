package assignment;

import java.math.BigDecimal;

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
                .map(item -> priceSource.getPrice(item.getName()).multiply(item.getWeight()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return perItemPrice.add(perWeightPrice);
    }
}
