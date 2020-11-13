package p1.myshop.entities;

import java.util.Objects;

public class CartItem {
    public final ItemId itemId;
    public final Quantity quantity;

    public CartItem(ItemId itemId, Quantity quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public ItemId itemId() {
        return itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(itemId, cartItem.itemId) &&
                Objects.equals(quantity, cartItem.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, quantity);
    }
}
