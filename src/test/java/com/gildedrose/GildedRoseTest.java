package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.gildedrose.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GildedRoseTest {
    @Test
    void testNull() {
        assertThrows(NullPointerException.class, () -> updateItemsWithDaysPassed(1, null));
    }

    @Test
    void testEmpty() {
        Item[] items = new Item[]{};

        updateItemsWithDaysPassed(1, items);

        assertThat(items).isEmpty();
    }

    @Nested
    class RandomItems {
        @Test
        void testWithRandomItemsDaysOne() {
            Item[] items = new Item[]{
                    new Item("item-0", 0, 0),
                    new Item("item-1", -5, 5),
                    new Item("item-2", 10, 3),
                    new Item("item-3", 0, 3)
            };

            updateItemsWithDaysPassed(1, items);

            assertItem(0, "item-0", -1, 0, items);
            assertItem(1, "item-1", -6, 3, items);
            assertItem(2, "item-2", 9, 2, items);
            assertItem(3, "item-3", -1, 1, items);
        }

        @Test
        void testWithRandomItemsDaysThree() {
            Item[] items = new Item[]{
                    new Item("item-0", 0, 0),
                    new Item("item-1", -5, 15),
                    new Item("item-2", 10, 12),
                    new Item("item-3", 0, 4)
            };

            updateItemsWithDaysPassed(3, items);

            assertItem(0, "item-0", -3, 0, items);
            assertItem(1, "item-1", -8, 9, items);
            assertItem(2, "item-2", 7, 9, items);
            assertItem(3, "item-3", -3, 0, items);
        }
    }

    @Nested
    class AgedBrieItems {
        @Test
        void testAgedBrieDaysOne() {
            Item[] items = new Item[]{
                    new Item(AGED_BRIE, 0, 0),
                    new Item(AGED_BRIE, -5, 50),
                    new Item(AGED_BRIE, 10, 5),
                    new Item(AGED_BRIE, 0, 50)
            };

            updateItemsWithDaysPassed(1, items);

            assertItem(0, AGED_BRIE, -1, 2, items);
            assertItem(1, AGED_BRIE, -6, 50, items);
            assertItem(2, AGED_BRIE, 9, 6, items);
            assertItem(3, AGED_BRIE, -1, 50, items);
        }

        @Test
        void testAgedBrieDaysThree() {
            Item[] items = new Item[]{
                    new Item(AGED_BRIE, 0, 0),
                    new Item(AGED_BRIE, -7, 50),
                    new Item(AGED_BRIE, 5, 5),
                    new Item(AGED_BRIE, 0, 50)
            };

            updateItemsWithDaysPassed(3, items);

            assertItem(0, AGED_BRIE, -3, 6, items);
            assertItem(1, AGED_BRIE, -10, 50, items);
            assertItem(2, AGED_BRIE, 2, 8, items);
            assertItem(3, AGED_BRIE, -3, 50, items);
        }
    }

    @Nested
    class SulfurasItems {
        @Test
        void testSulfurasDaysOne() {
            Item[] items = new Item[]{
                    new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80),
                    new Item(SULFURAS_HAND_OF_RAGNAROS, -5, 80),
                    new Item(SULFURAS_HAND_OF_RAGNAROS, 10, 80)
            };

            updateItemsWithDaysPassed(1, items);

            assertItem(0, SULFURAS_HAND_OF_RAGNAROS, 0, 80, items);
            assertItem(1, SULFURAS_HAND_OF_RAGNAROS, -5, 80, items);
            assertItem(2, SULFURAS_HAND_OF_RAGNAROS, 10, 80, items);
        }

        @Test
        void testSulfurasDaysThree() {
            Item[] items = new Item[]{
                    new Item(SULFURAS_HAND_OF_RAGNAROS, 10, 80),
                    new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80),
                    new Item(SULFURAS_HAND_OF_RAGNAROS, -1, 80)
            };

            updateItemsWithDaysPassed(3, items);

            assertItem(0, SULFURAS_HAND_OF_RAGNAROS, 10, 80, items);
            assertItem(1, SULFURAS_HAND_OF_RAGNAROS, 0, 80, items);
            assertItem(2, SULFURAS_HAND_OF_RAGNAROS, -1, 80, items);
        }
    }

    @Nested
    class BackstagePassesItems {
        @Test
        void testBackstagePassesDaysOne() {
            Item[] items = new Item[]{
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 0, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, -5, 50),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 1, 5),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 20, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 10, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 5, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 6, 50)
            };

            updateItemsWithDaysPassed(1, items);

            assertItem(0, BACKSTAGE_PASSES_TO_TAFKAL80ETC, -1, 0, items);
            assertItem(1, BACKSTAGE_PASSES_TO_TAFKAL80ETC, -6, 0, items);
            assertItem(2, BACKSTAGE_PASSES_TO_TAFKAL80ETC, 0, 8, items);
            assertItem(3, BACKSTAGE_PASSES_TO_TAFKAL80ETC, 19, 1, items);
            assertItem(4, BACKSTAGE_PASSES_TO_TAFKAL80ETC, 9, 2, items);
            assertItem(5, BACKSTAGE_PASSES_TO_TAFKAL80ETC, 4, 3, items);
            assertItem(6, BACKSTAGE_PASSES_TO_TAFKAL80ETC, 5, 50, items);
        }

        @Test
        void testBackstagePassesDaysThree() {
            Item[] items = new Item[]{
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 0, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, -5, 50),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 1, 5),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 20, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 10, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 5, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 6, 50)
            };

            updateItemsWithDaysPassed(3, items);

            assertItem(0, BACKSTAGE_PASSES_TO_TAFKAL80ETC, -3, 0, items);
            assertItem(1, BACKSTAGE_PASSES_TO_TAFKAL80ETC, -8, 0, items);
            assertItem(2, BACKSTAGE_PASSES_TO_TAFKAL80ETC, -2, 0, items);
            assertItem(3, BACKSTAGE_PASSES_TO_TAFKAL80ETC, 17, 3, items);
            assertItem(4, BACKSTAGE_PASSES_TO_TAFKAL80ETC, 7, 6, items);
            assertItem(5, BACKSTAGE_PASSES_TO_TAFKAL80ETC, 2, 9, items);
            assertItem(6, BACKSTAGE_PASSES_TO_TAFKAL80ETC, 3, 50, items);
        }
    }

    @Nested
    class ConjuredItems {
        @Test
        void testWithRandomItemsDaysOne() {
            Item[] items = new Item[]{
                    new Item(CONJURED_MANA_CAKE, 0, 0),
                    new Item(CONJURED_MANA_CAKE, -5, 5),
                    new Item(CONJURED_MANA_CAKE, 10, 3),
                    new Item(CONJURED_MANA_CAKE, 0, 5)
            };

            updateItemsWithDaysPassed(1, items);

            assertItem(0, CONJURED_MANA_CAKE, -1, 0, items);
            assertItem(1, CONJURED_MANA_CAKE, -6, 1, items);
            assertItem(2, CONJURED_MANA_CAKE, 9, 1, items);
            assertItem(3, CONJURED_MANA_CAKE, -1, 1, items);
        }

        @Test
        void testWithRandomItemsDaysThree() {
            Item[] items = new Item[]{
                    new Item(CONJURED_MANA_CAKE, 0, 0),
                    new Item(CONJURED_MANA_CAKE, -5, 15),
                    new Item(CONJURED_MANA_CAKE, 10, 12),
                    new Item(CONJURED_MANA_CAKE, 0, 4)
            };

            updateItemsWithDaysPassed(3, items);

            assertItem(0, CONJURED_MANA_CAKE, -3, 0, items);
            assertItem(1, CONJURED_MANA_CAKE, -8, 3, items);
            assertItem(2, CONJURED_MANA_CAKE, 7, 6, items);
            assertItem(3, CONJURED_MANA_CAKE, -3, 0, items);
        }
    }

    private void assertItem(int index, String name, int sellIn, int quality, Item[] items) {
        final Item item = items[index];
        assertThat(item.name).isEqualTo(name);
        assertThat(item.sellIn).isEqualTo(sellIn);
        assertThat(item.quality).isEqualTo(quality);
    }

    private void updateItemsWithDaysPassed(int days, Item[] items) {
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++)
            app.updateQuality();
    }
}
