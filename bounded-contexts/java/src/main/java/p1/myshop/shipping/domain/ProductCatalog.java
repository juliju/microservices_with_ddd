package p1.myshop.shipping.domain;

import p1.myshop.catalog.entities.Product;
import p1.myshop.catalog.entities.ProductId;

public interface ProductCatalog {
    Product get(ProductId productId);
}
