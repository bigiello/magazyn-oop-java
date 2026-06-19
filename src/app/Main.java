package app;

import model.ElectronicProduct;
import model.FoodProduct;
import model.Location;
import model.Product;
import model.StockItem;
import service.Warehouse;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse("Magazyn Centralny Warszawa");

        Product milk = new FoodProduct("SP-001", "Mleko 2%", 2.80, LocalDate.now().plusDays(7));
        Product yogurt = new FoodProduct("SP-002", "Jogurt naturalny", 1.50, LocalDate.now().minusDays(2));
        Product laptop = new ElectronicProduct("EL-001", "Laptop 14 cali", 2999.00, 24);

        warehouse.addItem(new StockItem(milk, new Location("Chłodnia", "A1", 2), 40));
        warehouse.addItem(new StockItem(yogurt, new Location("Chłodnia", "A1", 3), 12));
        warehouse.addItem(new StockItem(laptop, new Location("Strefa B", "B7", 1), 5));

        System.out.println("== Operacje ==");
        warehouse.receive("SP-001", 20);
        warehouse.release("EL-001", 2);
        System.out.println("Przyjęto 20 szt. mleka, wydano 2 laptopy.");

        try {
            warehouse.release("EL-001", 999);
        } catch (IllegalStateException e) {
            System.out.println("Odrzucono: " + e.getMessage());
        }

        System.out.println("\n== Stan magazynu: " + warehouse.getName() + " ==");
        for (StockItem item : warehouse.getItems()) {
            Product product = item.getProduct();
            System.out.printf(
                    "%-18s | %-12s | VAT %2d%% | stan: %3d | %s | wartość: %,.2f zł%n",
                    product.getName(),
                    product.category(),
                    Math.round(product.vatRate() * 100),
                    item.getQuantity(),
                    item.getLocation(),
                    item.grossValue());
        }
        System.out.printf("Łączna wartość magazynu (brutto): %,.2f zł%n", warehouse.totalValue());

        System.out.println("\n== Kontrola dat ważności ==");
        for (StockItem item : warehouse.getItems()) {
            if (item.getProduct() instanceof FoodProduct) {
                FoodProduct food = (FoodProduct) item.getProduct();
                String status = food.isExpired() ? "PRZETERMINOWANY!" : "OK";
                System.out.println(" - " + food.getName() + " (do " + food.getExpiryDate() + "): " + status);
            }
        }
    }
}
