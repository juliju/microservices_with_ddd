package p1.myshop.entities;

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
