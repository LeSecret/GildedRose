package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    private void incrementation_Qlty() {
        if (this.quality < 50) this.quality += 1;
    }

    private void decrementation_Qlty() {
        if (this.quality > 0) this.quality -= 1;
    }

    public void updateQuality() {
        sellIn -= 1;

        switch (name) {
            case "Sulfuras, Hand of Ragnaros":
                sellIn = 0;
                quality = 80;
                break;

            case "Aged Brie":
                this.incrementation_Qlty();
                if (sellIn < 0) this.incrementation_Qlty();
                break;

            case "Backstage passes to a TAFKAL80ETC concert":
                this.incrementation_Qlty();
                if (sellIn < 11) this.incrementation_Qlty();
                if (sellIn < 6) this.incrementation_Qlty();
                if (sellIn < 0) quality = 0;
                break;

            default :
                this.decrementation_Qlty();
                if (sellIn < 0) this.decrementation_Qlty();

        }
    }


   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
