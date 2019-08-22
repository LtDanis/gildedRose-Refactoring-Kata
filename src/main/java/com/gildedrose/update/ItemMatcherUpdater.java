package com.gildedrose.update;

import com.gildedrose.Item;

public interface ItemMatcherUpdater extends ItemUpdater {
    boolean matches(Item item);
}
