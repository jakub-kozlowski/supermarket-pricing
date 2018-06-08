package assignment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Basket {
    List<Item> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
    }

    public int itemCount() {
        return items.size();
    }

    public Collection<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
