package p1.myshop.services.shoppingcart;

import p1.myshop.entities.*;

import java.util.Collections;

public class ShoppingCartService {

    public Cart findUserCart(User user) {
        //TODO: Should go in the database to see if the user has already a cart
        return new Cart(user, Collections.emptyList());
    }

    public void addItem(Cart cart, Item item) {
        cart.appendItem(item);
    }

}
