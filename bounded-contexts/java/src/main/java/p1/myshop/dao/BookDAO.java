package p1.myshop.dao;

import p1.myshop.entities.Book;
import p1.myshop.entities.ItemId;

public interface BookDAO {
    Book find(ItemId itemId);
}
