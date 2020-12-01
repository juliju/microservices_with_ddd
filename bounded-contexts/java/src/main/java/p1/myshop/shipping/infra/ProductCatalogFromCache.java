package p1.myshop.shipping.infra;

import p1.myshop.catalog.entities.Product;
import p1.myshop.catalog.entities.ProductId;
import p1.myshop.shipping.domain.ProductCatalog;

public class ProductCatalogFromCache implements ProductCatalog {

    @Override
    public Product get(ProductId productId) {
        String jsonString = Cache.getOrCompute("http://127.0.0.1:4200/api/product/" + productId.id);
        JsonProduct jsonProduct = JsonProduct.fromString(jsonString);
        MapJsonToProduct mapper = new MapJsonToProduct();
        return mapper.map(jsonProduct);
    }
}
