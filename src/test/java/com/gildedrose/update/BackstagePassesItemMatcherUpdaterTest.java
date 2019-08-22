package com.gildedrose.update;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.gildedrose.utils.Constants.BACKSTAGE_PASSES_TO_TAFKAL80ETC;
import static org.assertj.core.api.Assertions.assertThat;

class BackstagePassesItemMatcherUpdaterTest extends ItemProcessorTest {
    private ItemMatcherUpdater processor;

    @BeforeEach
    void setUp() {
        processor = new BackstagePassesItemMatcherUpdater();
    }

    @Test
    void testIfMatchesWithDifferentName() {
        final boolean actual = processor.matches(new Item("RANDOM", 0, 0));

        assertThat(actual).isFalse();
    }

    @Test
    void testIfMatchesWithBackstagePassesName() {
        final boolean actual = processor.matches(new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 0, 0));

        assertThat(actual).isTrue();
    }

    @Test
    void testUpdateItemWithNegativeSellInAndMaxValue() {
        final Item actual = processor.updateItem(new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 0, 50));

        assertItem(actual, BACKSTAGE_PASSES_TO_TAFKAL80ETC, -1, 0);
    }

    @Test
    void testUpdateItemWithMaxValue() {
        final Item actual = processor.updateItem(new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 5, 50));

        assertItem(actual, BACKSTAGE_PASSES_TO_TAFKAL80ETC, 4, 50);
    }

    @Test
    void testUpdateItemWithNegativeSellIn() {
        final Item actual = processor.updateItem(new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 0, 0));

        assertItem(actual, BACKSTAGE_PASSES_TO_TAFKAL80ETC, -1, 0);
    }

    @Test
    void testUpdateItemWithSellInMoreThanTen() {
        final Item actual = processor.updateItem(new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 15, 0));

        assertItem(actual, BACKSTAGE_PASSES_TO_TAFKAL80ETC, 14, 1);
    }

    @Test
    void testUpdateItemWithSellInLessThanTen() {
        final Item actual = processor.updateItem(new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 10, 0));

        assertItem(actual, BACKSTAGE_PASSES_TO_TAFKAL80ETC, 9, 2);
    }


    @Test
    void testUpdateItemWithSellInLessThanFive() {
        final Item actual = processor.updateItem(new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 4, 0));

        assertItem(actual, BACKSTAGE_PASSES_TO_TAFKAL80ETC, 3, 3);
    }
}
