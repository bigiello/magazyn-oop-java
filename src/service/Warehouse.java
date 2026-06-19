package service;

import model.StockItem;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private final String name;
    private final List<StockItem> items = new ArrayList<>();

    public Warehouse(String name) {
        this.name = name;
    }

    public void addItem(StockItem item) {
        items.add(item);
    }

    public StockItem findBySku(String sku) {
        for (StockItem item : items) {
            if (item.getProduct().getSku().equals(sku)) {
                return item;
            }
        }
        return null;
    }

    public void receive(String sku, int amount) {
        StockItem item = findBySku(sku);
        if (item == null) {
            throw new IllegalArgumentException("Brak pozycji o SKU " + sku);
        }
        item.receive(amount);
    }

    public void release(String sku, int amount) {
        StockItem item = findBySku(sku);
        if (item == null) {
            throw new IllegalArgumentException("Brak pozycji o SKU " + sku);
        }
        item.release(amount);
    }

    public double totalValue() {
        double sum = 0;
        for (StockItem item : items) {
            sum += item.grossValue();
        }
        return sum;
    }

    public List<StockItem> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }
}
