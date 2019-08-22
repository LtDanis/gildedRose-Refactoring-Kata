package com.gildedrose.update;

import com.gildedrose.Item;

import static com.gildedrose.utils.Constants.AGED_BRIE;
import static com.gildedrose.utils.Constants.MAX_VALUE;

public class AgedBrieItemMatcherUpdater implements ItemMatcherUpdater {
    @Override
    public boolean matches(Item item) {
        return AGED_BRIE.equals(item.name);
    }

    @Override
    public Item updateItem(Item item) {
        final int sellIn = item.sellIn - 1;
        return new Item(item.name, sellIn, countNewQuality(sellIn, item.quality));
    }

    private int countNewQuality(int sellIn, int quality) {
        final int newQuality = sellIn > 0
                ? quality + 1
                : quality + 2;
        return newQuality < MAX_VALUE ? newQuality : MAX_VALUE;
    }
}
