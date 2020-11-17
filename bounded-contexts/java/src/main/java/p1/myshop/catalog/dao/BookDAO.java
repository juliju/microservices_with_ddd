package p1.myshop.catalog.dao;

import p1.myshop.catalog.entities.Book;
import p1.myshop.shoppingcart.entities.ItemId;

public interface BookDAO {
    Book find(ItemId itemId);
}
