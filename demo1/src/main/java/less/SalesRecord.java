package less;

import entity.Dish;
import less.CanteenMenu;

import java.util.HashMap;
import java.util.Map;

class SalesRecord {
    private Map<Dish, Integer> sales;

    public SalesRecord() {
        sales = new HashMap<>();
    }

    public void recordSale(Dish dish, int quantity) {
        sales.put(dish, sales.getOrDefault(dish, 0) + quantity);
        for (int i = 0; i < quantity; i++) {
            dish.sold();
        }
    }

    public void printSalesSummary() {
        System.out.println("Sales Summary:");
        double totalRevenue = 0.0;
        for (Map.Entry<Dish, Integer> entry : sales.entrySet()) {
            Dish dish = entry.getKey();
            int quantity = entry.getValue();
            double revenue = dish.getPrice() * quantity;
            totalRevenue += revenue;
            System.out.println("Dish: " + dish.getName() + ", Quantity: " + quantity + ", Revenue: " + revenue);
        }
        System.out.println("Total Revenue: " + totalRevenue);
    }

    // 示例用法
    public static void main(String[] args) {
        CanteenMenu menu = new CanteenMenu();
        Dish spaghetti = new Dish("Spaghetti", 8.99);
        Dish pizza = new Dish("Pizza", 10.99);
        menu.addDish(spaghetti);
        menu.addDish(pizza);

        SalesRecord record = new SalesRecord();
        record.recordSale(spaghetti, 3);
        record.recordSale(pizza, 2);
        record.printSalesSummary();
    }
}
