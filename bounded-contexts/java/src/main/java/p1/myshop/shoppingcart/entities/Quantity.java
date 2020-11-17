package p1.myshop.shoppingcart.entities;

public class Quantity {
    private final int quantity;

    private Quantity(int quantity) {
        this.quantity = quantity;
    }

    public static Quantity from(int quantity) {
        return new Quantity(quantity);
    }

    public Quantity add(int i) {
        return new Quantity(quantity + i);
    }

    public int getQuantity() {
        return quantity;
    }
}
