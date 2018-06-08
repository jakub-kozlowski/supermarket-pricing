package assignment;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.junit.Assert.assertThat;

public class PricingEngineTest {

    PricingEngine unit;

    @Before
    public void setup() {
        unit = new PricingEngine(new PriceSourceStub());
    }

    @Test
    public void whenCalledOnBasket_thenSumsUpPrices() {
        Basket basket = new Basket();
        basket.add(new Item("Beans"));
        basket.add(new Item("Coke"));

        assertThat(unit.price(basket), comparesEqualTo(new BigDecimal("1.20")));
    }

    @Test
    public void whenCalledOnBasketWithWeightedItems_thenSumsUpPrices() {
        Basket basket = new Basket();
        basket.add(new Item("Beans"));
        basket.add(new Item("Oranges", new BigDecimal("0.2")));

        assertThat(unit.price(basket), comparesEqualTo(new BigDecimal("0.90")));
    }

    @Test
    public void whenCalledOnBasketWithWeightedItems_andFractionalPrice_thenRoundsPriceUpToTwoDecimalPlaces() {
        unit = new PricingEngine(new PriceSource() {
            @Override
            public BigDecimal getPrice(String itemName) {
                return new BigDecimal("1.97");
            }
        });
        Basket basket = new Basket();
        basket.add(new Item("Oranges", new BigDecimal("0.2")));

        assertThat(unit.price(basket), comparesEqualTo(new BigDecimal("0.40")));
    }

    private class PriceSourceStub implements PriceSource {
        @Override
        public BigDecimal getPrice(String itemName) {
            return itemName.equals("Beans") ? new BigDecimal("0.5")
                    : itemName.equals("Coke") ? new BigDecimal("0.7")
                    : itemName.equals("Oranges") ? new BigDecimal("2")
                    : BigDecimal.ZERO;
        }
    }
}
