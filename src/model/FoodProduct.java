package model;

import java.time.LocalDate;

public class FoodProduct extends Product {

    private final LocalDate expiryDate;

    public FoodProduct(String sku, String name, double netPrice, LocalDate expiryDate) {
        super(sku, name, netPrice);
        this.expiryDate = expiryDate;
    }

    @Override
    public String category() {
        return "Spożywczy";
    }

    @Override
    public double vatRate() {
        return 0.05;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
