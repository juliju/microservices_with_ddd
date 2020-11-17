package p1.myshop.catalog.entities;


public class Dvd implements Product {
    private ProductId productId;
    private String ean;

    public Dvd(ProductId productId, String ean) {
        this.productId = productId;
        this.ean = ean;
    }

    @Override
    public ProductId itemId() {
        return null;
    }

    @Override
    public double weight() {
        return 0;
    }

    public String getEan() {
        return ean;
    }
}
