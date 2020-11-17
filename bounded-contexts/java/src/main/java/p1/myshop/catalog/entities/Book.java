package p1.myshop.catalog.entities;


public class Book implements Product {
    private ProductId productId;
    private String ean;

    public Book(ProductId productId, String ean) {
        this.productId = productId;
        this.ean = ean;
    }

    @Override
    public ProductId itemId() {
        return this.productId;
    }

    @Override
    public double weight() {
        return 0;
    }

    public String getEan() {
        return ean;
    }
}
