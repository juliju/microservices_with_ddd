package p1.myshop.shipping.services;

import p1.myshop.catalog.entities.Product;
import p1.myshop.catalog.entities.ProductId;
import p1.myshop.catalog.services.CatalogService;
import p1.myshop.shipping.dto.Cache;
import p1.myshop.shipping.dto.JsonProduct;
import p1.myshop.shipping.dto.MapJsonToProduct;
import p1.myshop.shipping.entities.DeliveryLine;
import p1.myshop.shipping.entities.DeliveryRequest;
import p1.myshop.shipping.entities.Item;
import p1.myshop.shipping.entities.Quantity;
import p1.myshop.shoppingcart.entities.Cart;
import p1.myshop.shoppingcart.entities.CartItemId;
import p1.myshop.shoppingcart.entities.CartLine;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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

        Product product0 = this.loadProductFromMonolith(productId);
        Product product1 = this.loadProductFromHttp(productId);
        Product product2 = this.loadAndCacheProductFromHttp(productId);

        // Catalog -> Shipping
        Item deliveryItem = convertToItem(product0);

        // Shopping Cart -> Shipping
        Quantity quantity = new Quantity(cartLine.quantity.getQuantity());

        return new DeliveryLine(deliveryItem, quantity);
    }

    private Product loadProductFromMonolith(ProductId productId) {
        return this.catalogService.loadProduct(productId);
    }

    private Product loadProductFromHttp(ProductId productId) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create("http://127.0.0.1:4200/api/product/" + productId.id))
                .build();
        HttpResponse<String> response = null;
        JsonProduct jsonProduct = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            jsonProduct = JsonProduct.fromString(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        MapJsonToProduct mapper = new MapJsonToProduct();

        return mapper.map(jsonProduct);
    }

    private Product loadAndCacheProductFromHttp(ProductId productId) {
        String jsonString = Cache.getOrCompute("http://127.0.0.1:4200/api/product/" + productId.id);
        JsonProduct jsonProduct = JsonProduct.fromString(jsonString);
        MapJsonToProduct mapper = new MapJsonToProduct();
        return mapper.map(jsonProduct);

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
