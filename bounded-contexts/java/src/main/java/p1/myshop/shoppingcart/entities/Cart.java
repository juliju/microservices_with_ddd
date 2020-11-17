package p1.myshop.shoppingcart.entities;


import java.util.List;


public class Cart {
    private User user;
    private List<CartLine> items;

    public Cart(User user, List<CartLine> items) {
        this.user = user;
        this.items = items;
    }

    public List<CartLine> items() {
        return items;
    }

    public void appendItem(CartItemId item) {
        // TODO add new item or increment quantity
    }
}
