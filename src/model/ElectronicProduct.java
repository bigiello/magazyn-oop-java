package model;

public class ElectronicProduct extends Product {

    private final int warrantyMonths;

    public ElectronicProduct(String sku, String name, double netPrice, int warrantyMonths) {
        super(sku, name, netPrice);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String category() {
        return "Elektronika";
    }

    @Override
    public double vatRate() {
        return 0.23;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }
}
