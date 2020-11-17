package p1.myshop.catalog.entities;

import p1.myshop.shoppingcart.entities.ItemId;

public interface Item extends HasWeight {
    ItemId itemId();
}
