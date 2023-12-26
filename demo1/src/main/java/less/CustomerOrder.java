package good;

import java.util.HashMap;
import java.util.Map;

class CustomerOrder {
    private String customerId;
    private Map<String, Integer> orderedItems; // Key: Item name, Value: Quantity
    private double totalCost;

    public CustomerOrder(String customerId) {
        this.customerId = customerId;
        this.orderedItems = new HashMap<>();
        this.totalCost = 0.0;
    }

    public void addItem(String itemName, int quantity, double price) {
        orderedItems.put(itemName, orderedItems.getOrDefault(itemName, 0) + quantity);
        totalCost += quantity * price;
    }

    public boolean makePayment(double amount) {
        if(amount >= totalCost) {
            System.out.println("Payment successful for customer " + customerId);
            return true;
        } else {
            System.out.println("Insufficient payment.");
            return false;
        }
    }

    public void printOrderSummary() {
        System.out.println("Order Summary for Customer ID: " + customerId);
        orderedItems.forEach((item, quantity) -> System.out.println(item + " x " + quantity));
        System.out.println("Total Cost: " + totalCost);
    }

    // 示例用法
    public static void main(String[] args) {
        CustomerOrder order = new CustomerOrder("Cust123");
        order.addItem("Apple", 5, 1.0);
        order.addItem("Banana", 3, 0.5);
        order.printOrderSummary();
        order.makePayment(10.0);
    }
}
