package com.gildedrose.processor;

import com.gildedrose.Item;

public interface ItemProcessor {
    boolean matches(Item item);

    Item updateItem(Item item);
}
