package Domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductInStore {
    private Product product;
    private int requiredAmount;
    private UUID barcode;
    private Category category;
    private List<Discount> discounts;
    private double price;

    public ProductInStore(Product product, int requiredAmount, UUID barcode, Category category, List<Discount> discounts, double price) {
        this.product = product;
        this.requiredAmount = requiredAmount;
        this.barcode = barcode;
        this.category = category;
        this.discounts = discounts;
        this.price = price;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public UUID getBarcode() {
        return barcode;
    }

    public void setBarcode(UUID barcode) {
        this.barcode = barcode;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName(){
        return product.getName();
    }


    //TODO: Decide what to do with the costs
    public void setSupplierCost(BigDecimal newSupplierCost){
    }

    //TODO: get supplier from product
    public String getSupplier() {
        return "Supplier";
    }
}
