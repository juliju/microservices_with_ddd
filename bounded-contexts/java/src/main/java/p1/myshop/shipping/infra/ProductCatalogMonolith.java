package p1.myshop.shipping.infra;

import p1.myshop.catalog.entities.Product;
import p1.myshop.catalog.entities.ProductId;
import p1.myshop.catalog.services.CatalogService;
import p1.myshop.shipping.domain.ProductCatalog;

public class ProductCatalogMonolith implements ProductCatalog {
    private CatalogService catalogService;

    public ProductCatalogMonolith(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Override
    public Product get(ProductId productId) {
        return this.catalogService.loadProduct(productId);
    }
}
