package com.gildedrose.update;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.gildedrose.utils.Constants.SULFURAS_HAND_OF_RAGNAROS;
import static org.assertj.core.api.Assertions.assertThat;

class SulfurasItemMatcherUpdaterTest extends ItemProcessorTest {
    private ItemMatcherUpdater processor;

    @BeforeEach
    void setUp() {
        processor = new SulfurasItemMatcherUpdater();
    }

    @Test
    void testIfMatchesWithRandomName() {
        final boolean actual = processor.matches(new Item("RANDOM", 0, 0));

        assertThat(actual).isFalse();
    }

    @Test
    void testIfMatchesWithAgedBrieName() {
        final boolean actual = processor.matches(new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 0));

        assertThat(actual).isTrue();
    }

    @Test
    void testValueDoesNotChange() {
        final Item actual = processor.updateItem(new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80));

        assertItem(actual, SULFURAS_HAND_OF_RAGNAROS, 0, 80);
    }

    @Test
    void testValueDoesNotChangeOnNegativeSellIn() {
        final Item actual = processor.updateItem(new Item(SULFURAS_HAND_OF_RAGNAROS, -5, 80));

        assertItem(actual, SULFURAS_HAND_OF_RAGNAROS, -5, 80);
    }
}
