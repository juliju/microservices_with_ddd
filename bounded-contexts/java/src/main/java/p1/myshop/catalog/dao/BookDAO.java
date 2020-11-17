package p1.myshop.catalog.dao;

import p1.myshop.catalog.entities.Book;
import p1.myshop.catalog.entities.ProductId;

public interface BookDAO {
    Book find(ProductId productId);
}
