package p1.myshop.entities;

public class Quantity {
    private final int quantity;

    private Quantity(int quantity) {
        this.quantity = quantity;
    }

    public static Quantity from(int quantity) {
        return new Quantity(quantity);
    }
}
