package p1.myshop.catalog.entities;

import p1.myshop.shoppingcart.entities.ItemId;

public class Book implements Item {
    private ItemId itemId;
    private String ean;

    public Book(ItemId itemId, String ean) {
        this.itemId = itemId;
        this.ean = ean;
    }

    @Override
    public ItemId itemId() {
        return this.itemId;
    }

    @Override
    public double weight() {
        return 0;
    }

    public String getEan() {
        return ean;
    }
}
