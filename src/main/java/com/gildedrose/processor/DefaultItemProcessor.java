package com.gildedrose.processor;

import com.gildedrose.Item;

import static com.gildedrose.utils.Constants.MIN_VALUE;

public class DefaultItemProcessor implements ItemProcessor {
    @Override
    public boolean matches(Item item) {
        return true;
    }

    @Override
    public Item updateItem(Item item) {
        final int sellIn = item.sellIn - 1;
        return new Item(item.name, sellIn, countNewQuality(sellIn, item.quality));
    }

    private int countNewQuality(int sellIn, int quality) {
        final int newQuality = sellIn > 0
                ? quality - 1
                : quality - 2;
        return newQuality > MIN_VALUE ? newQuality : MIN_VALUE;
    }
}
