package p1.myshop.shoppingcart.services;

import p1.myshop.shipping.services.DeliveryApi;
import p1.myshop.shoppingcart.entities.Cart;
import p1.myshop.shoppingcart.entities.CartItemId;
import p1.myshop.shoppingcart.entities.User;

import java.util.Collections;

public class ShoppingCartService {
    private final DeliveryApi deliveryApi;

    public ShoppingCartService() {
        this.deliveryApi = new DeliveryApi();
    }

    public Cart findUserCart(User user) {
        //TODO: Should go in the database to see if the user has already a cart
        return new Cart(user, Collections.emptyList());
    }

    public void addItem(Cart cart, CartItemId item) {
        cart.appendItem(item);
    }

    public void calculateWeight(Cart cart) {
        deliveryApi.calculateOrderWeight(cart);
    }

}
