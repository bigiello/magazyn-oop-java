package model;

public class StockItem {

    private final Product product;
    private final Location location;
    private int quantity;

    public StockItem(Product product, Location location, int initialQuantity) {
        if (product == null) {
            throw new IllegalArgumentException("Pozycja musi dotyczyć produktu.");
        }
        if (initialQuantity < 0) {
            throw new IllegalArgumentException("Stan początkowy nie może być ujemny.");
        }
        this.product = product;
        this.location = location;
        this.quantity = initialQuantity;
    }

    public void receive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Ilość przyjęcia musi być dodatnia.");
        }
        quantity += amount;
    }

    public void release(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Ilość wydania musi być dodatnia.");
        }
        if (amount > quantity) {
            throw new IllegalStateException(
                    "Za mało towaru: " + product.getName()
                    + " (dostępne: " + quantity + ", żądane: " + amount + ").");
        }
        quantity -= amount;
    }

    public double grossValue() {
        return product.grossPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Location getLocation() {
        return location;
    }

    public int getQuantity() {
        return quantity;
    }
}
