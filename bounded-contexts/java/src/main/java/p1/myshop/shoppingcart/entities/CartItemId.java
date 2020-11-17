package p1.myshop.shoppingcart.entities;

public class CartItemId {
    private final String id;

    private CartItemId(String id) {
        this.id = id;
    }

    public static CartItemId from(String s) {
        return new CartItemId(s);
    }
}
