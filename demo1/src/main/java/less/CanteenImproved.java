import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Dish {
    private String name;
    private double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class CanteenImproved {
    private List<Dish> menu;
    private Map<Dish, Integer> salesRecord;

    public CanteenImproved() {
        this.menu = new ArrayList<>();
        this.salesRecord = new HashMap<>();
    }

    public void addDishToMenu(Dish dish) {
        menu.add(dish);
    }

    public void sellDish(String dishName, int quantity) {
        for (Dish dish : menu) {
            if (dish.getName().equals(dishName)) {
                salesRecord.put(dish, salesRecord.getOrDefault(dish, 0) + quantity);
                break;
            }
        }
    }

    public void printSalesReport() {
        System.out.println("Canteen Sales Report:");
        double totalRevenue = 0;
        for (Map.Entry<Dish, Integer> entry : salesRecord.entrySet()) {
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
        CanteenImproved canteen = new CanteenImproved();
        canteen.addDishToMenu(new Dish("Spaghetti", 8.99));
        canteen.addDishToMenu(new Dish("Pizza", 10.99));

        canteen.sellDish("Spaghetti", 3);
        canteen.sellDish("Pizza", 2);

        canteen.printSalesReport();
    }
}
