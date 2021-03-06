package com.gildedrose.update;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.gildedrose.update.ItemProcessorTest.assertItem;
import static com.gildedrose.utils.Constants.AGED_BRIE;
import static org.assertj.core.api.Assertions.assertThat;

class AgedBrieItemMatcherUpdaterTest {
    private ItemMatcherUpdater processor;

    @BeforeEach
    void setUp() {
        processor = new AgedBrieItemMatcherUpdater();
    }

    @Test
    void testIfMatchesWithDifferentName() {
        final boolean actual = processor.matches(new Item("RANDOM", 0, 0));

        assertThat(actual).isFalse();
    }

    @Test
    void testIfMatchesWithAgedBrieName() {
        final boolean actual = processor.matches(new Item(AGED_BRIE, 0, 0));

        assertThat(actual).isTrue();
    }

    @Test
    void testUpdateItemWithNegativeSellInAndMaxValue() {
        final Item actual = processor.updateItem(new Item(AGED_BRIE, 0, 50));

        assertItem(actual, AGED_BRIE, -1, 50);
    }

    @Test
    void testUpdateItemWithMaxValue() {
        final Item actual = processor.updateItem(new Item(AGED_BRIE, 5, 50));

        assertItem(actual, AGED_BRIE, 4, 50);
    }

    @Test
    void testUpdateItemWithNegativeSellIn() {
        final Item actual = processor.updateItem(new Item(AGED_BRIE, 0, 0));

        assertItem(actual, AGED_BRIE, -1, 2);
    }

    @Test
    void testUpdateItem() {
        final Item actual = processor.updateItem(new Item(AGED_BRIE, 4, 0));

        assertItem(actual, AGED_BRIE, 3, 1);
    }
}
