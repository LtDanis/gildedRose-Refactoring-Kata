package com.gildedrose;

import java.util.stream.IntStream;

public class TextFixtureTest {
    private static final int DEFAULT_DAYS = 2;
    private static final Item[] ITEMS = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Conjured Mana Cake", 3, 6)
    };

    public static void main(String[] args) {
        GildedRose app = new GildedRose(ITEMS);

        int days = args.length > 0
                ? Integer.parseInt(args[0]) + 1
                : DEFAULT_DAYS;

        IntStream.range(0, days)
                .peek(TextFixtureTest::print)
                .forEach(day -> app.updateQuality());
    }

    private static void print(int day) {
        System.out.println("-------- day " + day + " --------");
        System.out.println("name, sellIn, quality");
        for (Item item : ITEMS)
            System.out.println(item);
        System.out.println();
    }
}
