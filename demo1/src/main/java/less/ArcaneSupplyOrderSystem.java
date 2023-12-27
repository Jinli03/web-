package good;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SupplyOrder {
    private String supplierName;
    private Map<String, Integer> itemsOrdered;

    public SupplyOrder(String supplierName) {
        this.supplierName = supplierName;
        this.itemsOrdered = new HashMap<>();
    }

    public void addItem(String itemName, int quantity) {
        itemsOrdered.put(itemName, itemsOrdered.getOrDefault(itemName, 0) + quantity);
    }

    public void printOrderDetails() {
        System.out.println("Order Details for Supplier: " + supplierName);
        for (Map.Entry<String, Integer> entry : itemsOrdered.entrySet()) {
            System.out.println("Item: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }
    }
}

class ArcaneSupplyOrderSystem {
    private List<SupplyOrder> orders;

    public ArcaneSupplyOrderSystem() {
        orders = new ArrayList<>();
    }

    public void addOrder(SupplyOrder order) {
        orders.add(order);
    }

    public void printAllOrders() {
        for (SupplyOrder order : orders) {
            order.printOrderDetails();
            System.out.println("------------------");
        }
    }

    // 示例用法
    public static void main(String[] args) {
        ArcaneSupplyOrderSystem system = new ArcaneSupplyOrderSystem();

        SupplyOrder order1 = new SupplyOrder("Best Suppliers Ltd.");
        order1.addItem("Tomatoes", 50);
        order1.addItem("Cheese", 20);
        system.addOrder(order1);

        SupplyOrder order2 = new SupplyOrder("Quality Foods Co.");
        order2.addItem("Bread", 100);
        order2.addItem("Lettuce", 30);
        system.addOrder(order2);

        system.printAllOrders();
    }
}
