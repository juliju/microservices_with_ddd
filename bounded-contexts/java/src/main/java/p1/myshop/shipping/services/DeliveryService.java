package p1.myshop.shipping.services;

import p1.myshop.catalog.entities.HasWeight;
import p1.myshop.catalog.services.CatalogService;
import p1.myshop.shoppingcart.entities.Cart;
import p1.myshop.shoppingcart.entities.CartItem;

public class DeliveryService {
    private final CatalogService catalogService;

    public DeliveryService(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    public double calculateOrderWeight(Cart cart) {
        return cart.items().stream()
                .map(CartItem::itemId)
                .map(catalogService::loadItem)
                .mapToDouble(HasWeight::weight)
                .sum();
    }
}
