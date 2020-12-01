package p1.myshop.shipping.api;

import p1.myshop.catalog.entities.Product;
import p1.myshop.catalog.entities.ProductId;
import p1.myshop.catalog.services.CatalogService;
import p1.myshop.shipping.domain.DeliveryService;
import p1.myshop.shipping.domain.ProductCatalog;
import p1.myshop.shipping.domain.entities.DeliveryLine;
import p1.myshop.shipping.domain.entities.DeliveryRequest;
import p1.myshop.shipping.domain.entities.Item;
import p1.myshop.shipping.domain.entities.Quantity;
import p1.myshop.shipping.infra.ProductCatalogHttp;
import p1.myshop.shoppingcart.entities.Cart;
import p1.myshop.shoppingcart.entities.CartItemId;
import p1.myshop.shoppingcart.entities.CartLine;

import java.util.List;
import java.util.stream.Collectors;

public class Delivery {

    private final CatalogService catalogService;
    private ProductCatalog productCatalog;

    public Delivery() {
        this.catalogService = new CatalogService();
        this.productCatalog = new ProductCatalogHttp();
        //this.productCatalog = new ProductCatalogFromCache();
        //this.productCatalog = new ProductCatalogMonolith(catalogService);
    }

    // Public Api
    public double calculateOrderWeight(Cart cart) {
        DeliveryRequest request = convertToDeliveryRequest(cart);
        DeliveryService deliveryService = new DeliveryService();
        return deliveryService.calculateDeliveryWeight(request);
    }

    // ShoppingCart -> Shipping
    private DeliveryRequest convertToDeliveryRequest(Cart cart) {
        List<DeliveryLine> lines = cart.items().stream()
                .map(this::toDeliveryLine)
                .collect(Collectors.toList());

        return new DeliveryRequest(lines);
    }

    // ShoppingCart -> (Catalog) -> Shipping
    private DeliveryLine toDeliveryLine(CartLine cartLine) {
        // Shopping Cart -> Catalog
        ProductId productId = convertToProductId(cartLine.cartItemId);

        Product product0 = this.productCatalog.get(productId);

        // Catalog -> Shipping
        Item deliveryItem = convertToItem(product0);

        // Shopping Cart -> Shipping
        Quantity quantity = new Quantity(cartLine.quantity.getQuantity());

        return new DeliveryLine(deliveryItem, quantity);
    }



    // TODO : Code this method
    // Cart -> Catalog
    private static ProductId convertToProductId(CartItemId cartItemId) {
        return null;
    }

    // TODO : Passe plat de weight
    // Catalog -> Shipping
    private static Item convertToItem(Product product) {
        return null;
    }


}
