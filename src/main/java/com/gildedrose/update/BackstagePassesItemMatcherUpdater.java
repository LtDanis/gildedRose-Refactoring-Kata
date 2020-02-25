package com.gildedrose.update;

import com.gildedrose.Item;

import static com.gildedrose.utils.Constants.BACKSTAGE_PASSES_TO_TAFKAL80ETC;
import static com.gildedrose.utils.Constants.MAX_VALUE;

public class BackstagePassesItemMatcherUpdater implements ItemMatcherUpdater {
    @Override
    public String getNameToMatch() {
        return BACKSTAGE_PASSES_TO_TAFKAL80ETC;
    }

    @Override
    public Item updateItem(Item item) {
        final int sellIn = item.sellIn - 1;
        return new Item(item.name, sellIn, countNewQuality(sellIn, item.quality));
    }

    private int countNewQuality(int sellIn, int quality) {
        final int newQuality = newQuality(sellIn, quality);
        return Math.min(newQuality, MAX_VALUE);
    }

    private int newQuality(int sellIn, int quality) {
        if (sellIn < 0)
            return 0;
        if (sellIn <= 5)
            return quality + 3;
        if (sellIn <= 10)
            return quality + 2;
        return quality + 1;
    }
}
