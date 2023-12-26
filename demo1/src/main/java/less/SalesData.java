package less;

import java.util.*;

class SalesData {
    private Map<String, Integer> dishSaleCount;

    public SalesData() {
        dishSaleCount = new HashMap<>();
    }

    public void recordSale(String dishName, int quantity) {
        dishSaleCount.put(dishName, dishSaleCount.getOrDefault(dishName, 0) + quantity);
    }

    public void printSalesReport() {
        System.out.println("Sales Report:");
        for (Map.Entry<String, Integer> entry : dishSaleCount.entrySet()) {
            System.out.println("Dish: " + entry.getKey() + ", Sold: " + entry.getValue());
        }
    }

    // 示例用法
    public static void main(String[] args) {
        SalesData salesData = new SalesData();
        salesData.recordSale("Spaghetti", 10);
        salesData.recordSale("Pizza", 15);
        salesData.recordSale("Spaghetti", 5);
        salesData.printSalesReport();
    }
}
