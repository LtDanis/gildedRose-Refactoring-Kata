package com.gildedrose.update;

import com.gildedrose.Item;

import static org.assertj.core.api.Assertions.assertThat;

class ItemProcessorTest {
    static void assertItem(Item actual, String name, int sellIn, int quality) {
        assertThat(actual.name).isEqualTo(name);
        assertThat(actual.sellIn).isEqualTo(sellIn);
        assertThat(actual.quality).isEqualTo(quality);
    }
}
