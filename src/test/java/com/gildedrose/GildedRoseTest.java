package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals("foo", element.name, "the name changed");
  }
  

  @Test
  void StringAgedBrie() {
    Item items = new Item("Aged Brie", 2, 0);
    GildedRose app = new GildedRose(new Item[] {items});
    app.updateQuality();
    assertEquals("Aged Brie, 1, 1", app.items[0].toString(), "Mauvaise mise à jour");
    }

  @Test
  void StringBackstage() {
    Item items = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
    GildedRose app = new GildedRose(new Item[] {items});
    app.updateQuality();
    assertEquals("Backstage passes to a TAFKAL80ETC concert, 14, 21", app.items[0].toString(), "Mauvaise mise à jour");
    }

  @Test
  void StringConjured() {
    Item items = new Item("Conjured Mana Cake", 3, 6);
    GildedRose app = new GildedRose(new Item[] {items});
    app.updateQuality();
    assertEquals("Conjured Mana Cake, 2, 4", app.items[0].toString(), "Mauvaise mise à jour");
    }


  @Test
  @DisplayName("Test pour voir le changement des articles par défaut")
  void ArticleDefautTest() {
    Item element1 = new Item("article", 2, 50);
    Item element2 = new Item("article", 0, 50);
    Item element3 = new Item("article", -2, 6);

    GildedRose app = new GildedRose(new Item[] {element1, element2, element3});
    app.updateQuality();
    assertEquals(49, element1.quality, "La qualité n'a pas été changé");
    assertEquals(48, element2.quality, "La qualité n'a pas été changé");
    assertEquals(4, element3.quality, "La qualité n'a pas été changé");
  }

  @Test
  @DisplayName("Test pour que la qualité ne dépasse pas 50")
  void QualityTest() {
    Item element1 = new Item("Aged Brie", 2, 50);
    Item element2 = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 48);

    GildedRose app = new GildedRose(new Item[] {element1, element2});
    app.updateQuality();
    assertEquals(50, element1.quality, "La qualité a dépassé 50");
    assertEquals(50, element2.quality, "La qualité a dépassé 50");
  }

  @Test
  @DisplayName("Test sur la date et la qualité de Sulfuras, Hand of Ragnaros")
  void sulfurasTest() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.sellIn, "Mauvaise mise à jour de la date");
    assertEquals(80, element.quality, "Mauvaise mise à jour de la qualité");
  }

  @Test
  @DisplayName("Test sur sellIn et quality de Aged Brie")
  void AgedBrieTest() {
    Item element1 = new Item("Aged Brie", 2, 0);
    Item element2 = new Item("Aged Brie", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element1, element2});
    app.updateQuality();
    assertEquals(1, element1.sellIn, "Mauvaise mise à jour de la date de pérumption");
    assertEquals(1, element1.quality, "Mauvaise mise à jour de la qualité");
    assertEquals(-1, element2.sellIn, "Mauvaise mise à jour de la date de pérumption");
    assertEquals(2, element2.quality, "Mauvaise mise à jour de la qualité");
  }


  @Test
  @DisplayName("Test sur sellin et quality de Backstage passes to a TAFKAL80ETC concert")
  void BackstageTest() {
    Item element1 = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
    Item element2 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
    Item element3 = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
    Item element4 = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);

    GildedRose app = new GildedRose(new Item[] {element1, element2, element3, element4});
    app.updateQuality();
    assertEquals(14, element1.sellIn, "Mauvaise mise à jour de la date de pérumption");
    assertEquals(21, element1.quality, "Mauvaise mise à jour de la qualité");

    assertEquals(9, element2.sellIn, "Mauvaise mise à jour de la date de pérumption");
    assertEquals(22, element2.quality, "Mauvaise mise à jour de la qualité");

    assertEquals(4, element3.sellIn, "Mauvaise mise à jour de la date de pérumption");
    assertEquals(23, element3.quality, "Mauvaise mise à jour de la date qualité");

    assertEquals(-1, element4.sellIn, "Mauvaise mise à jour de la date de pérumption");
    assertEquals(0, element4.quality, "Mauvaise mise à jour de la qualité");
  }

  @Test
  @DisplayName("Test sur sellin et quality de Conjured Mana Cake")
  void conjuredTest() {
    Item element = new Item("Conjured Mana Cake", 3, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(2, element.sellIn, "Mauvaise mise à jour de la date de pérumption");
    assertEquals(48, element.quality, "Mauvaise mise à jour de la qualité");
  }

  @Test
    void conjuredTest2() {
        int q = 0;
        Item[] items = new Item[]{new Item("Conjured Mana Cake", -1, q)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(q, items[0].quality, "Mauvaise mise à jour de la date de qualité");
    }


  
 
}
