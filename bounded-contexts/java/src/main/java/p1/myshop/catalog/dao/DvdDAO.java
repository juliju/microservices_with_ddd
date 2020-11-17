package p1.myshop.catalog.dao;

import p1.myshop.catalog.entities.Dvd;
import p1.myshop.catalog.entities.ProductId;

public interface DvdDAO {
    Dvd find(ProductId productId);
}
