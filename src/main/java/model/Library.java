package model;

import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Item> items;

    Library() {
        items = new ArrayList<>();
    }

    void addItems(Item item) {
        items.add(item);
    }

    boolean searchItem(Item item) {
        return items.contains(item);
    }

    void removeItem(Item item) {
        if (!items.remove(item)) {
            throw new ItemNotFoundException();
        }
        items.remove(item);
    }

}
