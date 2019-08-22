package com.gildedrose.update;

import com.gildedrose.Item;

public interface ItemMatcherUpdater extends ItemUpdater {
    String getNameToMatch();

    default boolean matches(Item item) {
        return getNameToMatch().equals(item.name);
    }
}
