package assignment;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasketTest {
    public static final String ANY_ITEM_NAME = "anyItemName";

    Basket unit;

    @Before
    public void init() {
        unit = new Basket();
    }

    @Test
    public void whenItemAddedToEmptyBasket_thenBasketHasOneItem() {
        unit.add(new Item(ANY_ITEM_NAME));
        assertThat(unit.itemCount(), is(1));
    }
}
