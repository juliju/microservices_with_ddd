package p1.myshop.entities;

import java.util.List;


public class Cart {
    private User user;
    private List<CartItem> items;

    public Cart(User user, List<CartItem> items) {
        this.user = user;
        this.items = items;
    }

    public List<CartItem> items() {
        return items;
    }

    public void appendItem(Item item) {
        // TODO add new item or increment quantity
    }
}
