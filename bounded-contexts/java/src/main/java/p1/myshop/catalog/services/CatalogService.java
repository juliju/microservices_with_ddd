package p1.myshop.catalog.services;

import p1.myshop.catalog.dao.BookDAO;
import p1.myshop.catalog.dao.DvdDAO;
import p1.myshop.catalog.entities.Product;
import p1.myshop.catalog.entities.ProductId;


public class CatalogService {
    private BookDAO bookDao;
    private DvdDAO dvdDao;

    public Product loadProduct(ProductId productId) {
        Product product1 = bookDao.find(productId);
        Product product2 = dvdDao.find(productId);

        if (product1 == null) {
            return product2;
        }

        return product1;
    }
}
