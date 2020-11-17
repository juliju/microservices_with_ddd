package p1.myshop.shipping.services;

import p1.myshop.catalog.entities.Product;
import p1.myshop.catalog.entities.ProductId;
import p1.myshop.catalog.services.CatalogService;
import p1.myshop.shipping.entities.DeliveryLine;
import p1.myshop.shipping.entities.DeliveryRequest;
import p1.myshop.shipping.entities.Item;
import p1.myshop.shipping.entities.Quantity;
import p1.myshop.shoppingcart.entities.Cart;
import p1.myshop.shoppingcart.entities.CartItemId;
import p1.myshop.shoppingcart.entities.CartLine;

import java.util.List;
import java.util.stream.Collectors;

public class DeliveryApi {

    private final CatalogService catalogService;

    public DeliveryApi() {
        this.catalogService = new CatalogService();
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

        Product product = catalogService.loadProduct(productId);
        // Catalog -> Shipping
        Item deliveryItem = convertToItem(product);

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
