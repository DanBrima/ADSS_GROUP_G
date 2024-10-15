package Domain;

import Presentation.IO;

import java.util.UUID;

public class ProductInContract {
    private Product product;
    private double price;
    private int productDiscountPercentage;
    private UUID supplierCatalogID;

    public ProductInContract(Product product, int price, int productDiscountPercentage) {
        this.product = product;
        this.price = price;
        this.productDiscountPercentage = productDiscountPercentage;
        this.supplierCatalogID = UUID.randomUUID();
    }

    public static ProductInContract getContractFromIO(IO io) {
        Product product = Product.getProductFromIO(io);
        int price = io.readInt("Enter the price of the product:");
        int productDiscountPercentage = io.readInt("Enter the discount percentage of the product:");
        return new ProductInContract(product, price, productDiscountPercentage);
    }

    public String name() {
        return product.name;
    }

    public UUID supplierCatalogID() {
        return this.supplierCatalogID;
    }

    public double price() {
        return this.price;
    }

    public double priceWithDiscount() {
        return this.price * (1 - this.productDiscountPercentage / 100.0);
    }

    @Override
    public String toString() {
        return "{product=" + product +
                ", price=" + price +
                ", productDiscountPercentage=" + productDiscountPercentage +
                ", supplierCatalogID=" + supplierCatalogID +
                '}';
    }
}
