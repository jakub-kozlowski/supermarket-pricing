package assignment;

import java.math.BigDecimal;

public interface PriceSource {
    BigDecimal getPrice(String itemName);
}
