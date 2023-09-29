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
}
