package com.gildedrose.update;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.gildedrose.utils.Constants.CONJURED_MANA_CAKE;
import static org.assertj.core.api.Assertions.assertThat;

class ConjuredItemMatcherUpdaterTest extends ItemProcessorTest {
    private ItemMatcherUpdater processor;

    @BeforeEach
    void setUp() {
        processor = new ConjuredItemMatcherUpdater();
    }

    @Test
    void testIfMatchesWithDifferentName() {
        final boolean actual = processor.matches(new Item("RANDOM", 0, 0));

        assertThat(actual).isFalse();
    }

    @Test
    void testIfMatchesWithAgedBrieName() {
        final boolean actual = processor.matches(new Item(CONJURED_MANA_CAKE, 0, 0));

        assertThat(actual).isTrue();
    }

    @Test
    void testUpdateItemNegativeSellInMinValue() {
        final Item actual = processor.updateItem(new Item(CONJURED_MANA_CAKE, 0, 0));

        assertItem(actual, CONJURED_MANA_CAKE, -1, 0);
    }

    @Test
    void testUpdateItemMinValue() {
        final Item actual = processor.updateItem(new Item(CONJURED_MANA_CAKE, 5, 0));

        assertItem(actual, CONJURED_MANA_CAKE, 4, 0);
    }

    @Test
    void testUpdateItemWithNegativeSellIn() {
        final Item actual = processor.updateItem(new Item(CONJURED_MANA_CAKE, 0, 5));

        assertItem(actual, CONJURED_MANA_CAKE, -1, 1);
    }

    @Test
    void testUpdateItem() {
        final Item actual = processor.updateItem(new Item(CONJURED_MANA_CAKE, 4, 10));

        assertItem(actual, CONJURED_MANA_CAKE, 3, 8);
    }
}
