package com.gildedrose.processor;

import com.gildedrose.Item;

import static com.gildedrose.utils.Constants.CONJURED_MANA_CAKE;
import static com.gildedrose.utils.Constants.MIN_VALUE;

public class ConjuredItemProcessor implements ItemProcessor {
    @Override
    public boolean matches(Item item) {
        return CONJURED_MANA_CAKE.equals(item.name);
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
