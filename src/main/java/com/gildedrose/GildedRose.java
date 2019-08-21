package com.gildedrose;

import com.gildedrose.processor.*;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

class GildedRose {
    private final List<ItemProcessor> processors = asList(
            new BackstagePassesItemProcessor(),
            new AgedBrieItemProcessor(),
            new SulfurasItemProcessor(),
            new ConjuredItemProcessor()
    );
    private final ItemProcessor defaultProcessor = new DefaultItemProcessor();

    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        items = Stream.of(items)
                .map(this::updateItem)
                .toArray(Item[]::new);
    }

    private Item updateItem(Item item) {
        return processors.stream()
                .filter(p -> p.matches(item))
                .findFirst()
                .map(p -> p.updateItem(item))
                .orElse(defaultProcessor.updateItem(item));
    }
}
