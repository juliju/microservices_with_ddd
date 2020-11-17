package p1.myshop.shipping.entities;

public class DeliveryLine {
    private final Item item;
    private final Quantity quantity;

    public DeliveryLine(Item item, Quantity quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
