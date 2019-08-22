package com.gildedrose.update;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefaultItemUpdaterTest extends ItemProcessorTest {
    private static final String RANDOM_NAME = "RANDOM";
    private ItemUpdater processor;

    @BeforeEach
    void setUp() {
        processor = new DefaultItemUpdater();
    }

    @Test
    void testUpdateItemNegativeSellInMinValue() {
        final Item actual = processor.updateItem(new Item(RANDOM_NAME, 0, 0));

        assertItem(actual, RANDOM_NAME, -1, 0);
    }

    @Test
    void testUpdateItemWithMinValue() {
        final Item actual = processor.updateItem(new Item(RANDOM_NAME, 5, 0));

        assertItem(actual, RANDOM_NAME, 4, 0);
    }

    @Test
    void testUpdateItemWithNegativeSellIn() {
        final Item actual = processor.updateItem(new Item(RANDOM_NAME, 0, 5));

        assertItem(actual, RANDOM_NAME, -1, 3);
    }

    @Test
    void testUpdateItem() {
        final Item actual = processor.updateItem(new Item(RANDOM_NAME, 4, 10));

        assertItem(actual, RANDOM_NAME, 3, 9);
    }
}
