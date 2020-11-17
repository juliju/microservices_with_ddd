package p1.myshop.shoppingcart.entities;

import java.util.Objects;

public class CartLine {
    public final CartItemId cartItemId;
    public final Quantity quantity;

    public CartLine(CartItemId cartItemId, Quantity quantity) {
        this.cartItemId = cartItemId;
        this.quantity = quantity;
    }

    public CartItemId itemId() {
        return cartItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartLine cartLine = (CartLine) o;
        return Objects.equals(cartItemId, cartLine.cartItemId) &&
                Objects.equals(quantity, cartLine.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartItemId, quantity);
    }
}
