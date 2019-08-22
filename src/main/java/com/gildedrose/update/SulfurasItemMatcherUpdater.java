package com.gildedrose.update;

import com.gildedrose.Item;

import static com.gildedrose.utils.Constants.SULFURAS_HAND_OF_RAGNAROS;

public class SulfurasItemMatcherUpdater implements ItemMatcherUpdater {
    @Override
    public boolean matches(Item item) {
        return SULFURAS_HAND_OF_RAGNAROS.equals(item.name);
    }

    @Override
    public Item updateItem(Item item) {
        return new Item(item.name, item.sellIn, item.quality);
    }
}
