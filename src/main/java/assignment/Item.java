package assignment;

import java.math.BigDecimal;

public class Item {
    private final String name;
    private BigDecimal weight;
    private final ItemPricingType pricingType;

    public Item(String name, BigDecimal weight) {
        this.name = name;
        this.weight = weight;
        this.pricingType = ItemPricingType.PRICING_PER_WEIGHT;
    }

    public Item(String name) {
        this.name = name;
        this.pricingType = ItemPricingType.PRICING_PER_ITEM;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public ItemPricingType getPricingType() {
        return pricingType;
    }
}
