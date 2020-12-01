package p1.myshop.shipping.infra;

import p1.myshop.catalog.entities.Product;
import p1.myshop.catalog.entities.ProductId;
import p1.myshop.shipping.domain.ProductCatalog;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ProductCatalogHttp implements ProductCatalog {
    @Override
    public Product get(ProductId productId) {
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
}
