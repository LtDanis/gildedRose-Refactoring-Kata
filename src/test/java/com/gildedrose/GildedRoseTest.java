package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.gildedrose.utils.Constants.*;
import static java.util.Arrays.asList;
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

        final List<Item> actual = updateItemsWithDaysPassed(1, items);

        assertThat(actual).isEmpty();
    }

    @Nested
    class RandomItems {
        @Test
        void testWithRandomItemsDaysOne() {
            final Item[] items = new Item[]{
                    new Item("item-0", 0, 0),
                    new Item("item-1", -5, 5),
                    new Item("item-2", 10, 3),
                    new Item("item-3", 0, 3)
            };

            final List<Item> actual = updateItemsWithDaysPassed(1, items);

            assertItem(actual.get(0), "item-0", -1, 0);
            assertItem(actual.get(1), "item-1", -6, 3);
            assertItem(actual.get(2), "item-2", 9, 2);
            assertItem(actual.get(3), "item-3", -1, 1);
        }

        @Test
        void testWithRandomItemsDaysThree() {
            final Item[] items = new Item[]{
                    new Item("item-0", 0, 0),
                    new Item("item-1", -5, 15),
                    new Item("item-2", 10, 12),
                    new Item("item-3", 0, 4)
            };

            final List<Item> actual = updateItemsWithDaysPassed(3, items);

            assertItem(actual.get(0), "item-0", -3, 0);
            assertItem(actual.get(1), "item-1", -8, 9);
            assertItem(actual.get(2), "item-2", 7, 9);
            assertItem(actual.get(3), "item-3", -3, 0);
        }
    }

    @Nested
    class AgedBrieItems {
        @Test
        void testAgedBrieDaysOne() {
            final Item[] items = new Item[]{
                    new Item(AGED_BRIE, 0, 0),
                    new Item(AGED_BRIE, -5, 50),
                    new Item(AGED_BRIE, 10, 5),
                    new Item(AGED_BRIE, 0, 50)
            };

            final List<Item> actual = updateItemsWithDaysPassed(1, items);

            assertItem(actual.get(0), AGED_BRIE, -1, 2);
            assertItem(actual.get(1), AGED_BRIE, -6, 50);
            assertItem(actual.get(2), AGED_BRIE, 9, 6);
            assertItem(actual.get(3), AGED_BRIE, -1, 50);
        }

        @Test
        void testAgedBrieDaysThree() {
            final Item[] items = new Item[]{
                    new Item(AGED_BRIE, 0, 0),
                    new Item(AGED_BRIE, -7, 50),
                    new Item(AGED_BRIE, 5, 5),
                    new Item(AGED_BRIE, 0, 50)
            };

            final List<Item> actual = updateItemsWithDaysPassed(3, items);

            assertItem(actual.get(0), AGED_BRIE, -3, 6);
            assertItem(actual.get(1), AGED_BRIE, -10, 50);
            assertItem(actual.get(2), AGED_BRIE, 2, 8);
            assertItem(actual.get(3), AGED_BRIE, -3, 50);
        }
    }

    @Nested
    class SulfurasItems {
        @Test
        void testSulfurasDaysOne() {
            final Item[] items = new Item[]{
                    new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80),
                    new Item(SULFURAS_HAND_OF_RAGNAROS, -5, 80),
                    new Item(SULFURAS_HAND_OF_RAGNAROS, 10, 80)
            };

            final List<Item> actual = updateItemsWithDaysPassed(1, items);

            assertItem(actual.get(0), SULFURAS_HAND_OF_RAGNAROS, 0, 80);
            assertItem(actual.get(1), SULFURAS_HAND_OF_RAGNAROS, -5, 80);
            assertItem(actual.get(2), SULFURAS_HAND_OF_RAGNAROS, 10, 80);
        }

        @Test
        void testSulfurasDaysThree() {
            final Item[] items = new Item[]{
                    new Item(SULFURAS_HAND_OF_RAGNAROS, 10, 80),
                    new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80),
                    new Item(SULFURAS_HAND_OF_RAGNAROS, -1, 80)
            };

            final List<Item> actual = updateItemsWithDaysPassed(3, items);

            assertItem(actual.get(0), SULFURAS_HAND_OF_RAGNAROS, 10, 80);
            assertItem(actual.get(1), SULFURAS_HAND_OF_RAGNAROS, 0, 80);
            assertItem(actual.get(2), SULFURAS_HAND_OF_RAGNAROS, -1, 80);
        }
    }

    @Nested
    class BackstagePassesItems {
        @Test
        void testBackstagePassesDaysOne() {
            final Item[] items = new Item[]{
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 0, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, -5, 50),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 1, 5),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 20, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 10, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 5, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 6, 50)
            };

            final List<Item> actual = updateItemsWithDaysPassed(1, items);

            assertItem(actual.get(0), BACKSTAGE_PASSES_TO_TAFKAL80ETC, -1, 0);
            assertItem(actual.get(1), BACKSTAGE_PASSES_TO_TAFKAL80ETC, -6, 0);
            assertItem(actual.get(2), BACKSTAGE_PASSES_TO_TAFKAL80ETC, 0, 8);
            assertItem(actual.get(3), BACKSTAGE_PASSES_TO_TAFKAL80ETC, 19, 1);
            assertItem(actual.get(4), BACKSTAGE_PASSES_TO_TAFKAL80ETC, 9, 2);
            assertItem(actual.get(5), BACKSTAGE_PASSES_TO_TAFKAL80ETC, 4, 3);
            assertItem(actual.get(6), BACKSTAGE_PASSES_TO_TAFKAL80ETC, 5, 50);
        }

        @Test
        void testBackstagePassesDaysThree() {
            final Item[] items = new Item[]{
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 0, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, -5, 50),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 1, 5),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 20, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 10, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 5, 0),
                    new Item(BACKSTAGE_PASSES_TO_TAFKAL80ETC, 6, 50)
            };

            final List<Item> actual = updateItemsWithDaysPassed(3, items);

            assertItem(actual.get(0), BACKSTAGE_PASSES_TO_TAFKAL80ETC, -3, 0);
            assertItem(actual.get(1), BACKSTAGE_PASSES_TO_TAFKAL80ETC, -8, 0);
            assertItem(actual.get(2), BACKSTAGE_PASSES_TO_TAFKAL80ETC, -2, 0);
            assertItem(actual.get(3), BACKSTAGE_PASSES_TO_TAFKAL80ETC, 17, 3);
            assertItem(actual.get(4), BACKSTAGE_PASSES_TO_TAFKAL80ETC, 7, 6);
            assertItem(actual.get(5), BACKSTAGE_PASSES_TO_TAFKAL80ETC, 2, 9);
            assertItem(actual.get(6), BACKSTAGE_PASSES_TO_TAFKAL80ETC, 3, 50);
        }
    }

    @Nested
    class ConjuredItems {
        @Test
        void testWithRandomItemsDaysOne() {
            final Item[] items = new Item[]{
                    new Item(CONJURED_MANA_CAKE, 0, 0),
                    new Item(CONJURED_MANA_CAKE, -5, 5),
                    new Item(CONJURED_MANA_CAKE, 10, 3),
                    new Item(CONJURED_MANA_CAKE, 0, 5)
            };

            final List<Item> actual = updateItemsWithDaysPassed(1, items);

            assertItem(actual.get(0), CONJURED_MANA_CAKE, -1, 0);
            assertItem(actual.get(1), CONJURED_MANA_CAKE, -6, 1);
            assertItem(actual.get(2), CONJURED_MANA_CAKE, 9, 1);
            assertItem(actual.get(3), CONJURED_MANA_CAKE, -1, 1);
        }

        @Test
        void testWithRandomItemsDaysThree() {
            final Item[] items = new Item[]{
                    new Item(CONJURED_MANA_CAKE, 0, 0),
                    new Item(CONJURED_MANA_CAKE, -5, 15),
                    new Item(CONJURED_MANA_CAKE, 10, 12),
                    new Item(CONJURED_MANA_CAKE, 0, 4)
            };

            final List<Item> actual = updateItemsWithDaysPassed(3, items);

            assertItem(actual.get(0), CONJURED_MANA_CAKE, -3, 0);
            assertItem(actual.get(1), CONJURED_MANA_CAKE, -8, 3);
            assertItem(actual.get(2), CONJURED_MANA_CAKE, 7, 6);
            assertItem(actual.get(3), CONJURED_MANA_CAKE, -3, 0);
        }
    }

    private void assertItem(Item item, String name, int sellIn, int quality) {
        assertThat(item.name).isEqualTo(name);
        assertThat(item.sellIn).isEqualTo(sellIn);
        assertThat(item.quality).isEqualTo(quality);
    }

    private List<Item> updateItemsWithDaysPassed(int days, Item[] items) {
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++)
            app.updateQuality();
        return asList(app.items);
    }
}
