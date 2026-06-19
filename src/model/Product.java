package model;

public abstract class Product {

    private final String sku;
    private String name;
    private double netPrice;

    protected Product(String sku, String name, double netPrice) {
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU nie może być puste.");
        }
        if (netPrice < 0) {
            throw new IllegalArgumentException("Cena nie może być ujemna.");
        }
        this.sku = sku;
        this.name = name;
        this.netPrice = netPrice;
    }

    public abstract String category();

    public abstract double vatRate();

    public double grossPrice() {
        return netPrice * (1 + vatRate());
    }

    public void changePrice(double newPrice) {
        if (newPrice < 0) {
            throw new IllegalArgumentException("Cena nie może być ujemna.");
        }
        this.netPrice = newPrice;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getNetPrice() {
        return netPrice;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s)", sku, name, category());
    }
}
