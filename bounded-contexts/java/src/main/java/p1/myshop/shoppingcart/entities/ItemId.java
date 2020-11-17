package p1.myshop.shoppingcart.entities;

public class ItemId {
    private final String id;

    private ItemId(String id) {
        this.id = id;
    }

    public static ItemId from(String s) {
        return new ItemId(s);
    }
}
