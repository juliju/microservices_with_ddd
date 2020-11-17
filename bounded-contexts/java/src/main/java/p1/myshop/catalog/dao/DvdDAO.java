package p1.myshop.catalog.dao;

import p1.myshop.catalog.entities.Dvd;
import p1.myshop.shoppingcart.entities.ItemId;

public interface DvdDAO {
    Dvd find(ItemId itemId);
}
