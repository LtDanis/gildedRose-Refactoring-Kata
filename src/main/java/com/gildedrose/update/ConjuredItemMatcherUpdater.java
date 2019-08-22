package com.gildedrose.update;

import com.gildedrose.Item;

import static com.gildedrose.utils.Constants.CONJURED_MANA_CAKE;
import static com.gildedrose.utils.Constants.MIN_VALUE;

public class ConjuredItemMatcherUpdater implements ItemMatcherUpdater {
    @Override
    public String getNameToMatch() {
        return CONJURED_MANA_CAKE;
    }

    @Override
    public Item updateItem(Item item) {
        final int sellIn = item.sellIn - 1;
        return new Item(item.name, sellIn, countNewQuality(sellIn, item.quality));
    }

    private int countNewQuality(int sellIn, int quality) {
        final int newQuality = sellIn > 0
                ? quality - 2
                : quality - 4;
        return newQuality > MIN_VALUE ? newQuality : MIN_VALUE;
    }
}
