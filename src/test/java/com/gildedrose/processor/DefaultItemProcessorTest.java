package com.gildedrose.processor;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultItemProcessorTest extends ItemProcessorTest {
    private static final String RANDOM_NAME = "RANDOM";
    private ItemProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new DefaultItemProcessor();
    }

    @Test
    void testIfMatchesWithRandomName() {
        final boolean actual = processor.matches(new Item(RANDOM_NAME, 0, 0));

        assertThat(actual).isTrue();
    }

    @Test
    void testUpdateItemNegativeSellInMinValue() {
        final Item actual = processor.updateItem(new Item(RANDOM_NAME, 0, 0));

        assertItem(actual, RANDOM_NAME, -1, 0);
    }

    @Test
    void testUpdateItemMinValue() {
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
