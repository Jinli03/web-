package good;

import java.util.*;

class DishSalesRanking {
    private Map<String, Integer> dishSales;

    public DishSalesRanking() {
        dishSales = new HashMap<>();
    }

    public void recordDishSale(String dishName, int quantity) {
        dishSales.put(dishName, dishSales.getOrDefault(dishName, 0) + quantity);
    }

    public void printTopSellingDishes(int topN) {
        System.out.println("Top " + topN + " Selling Dishes:");
        dishSales.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(topN)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    // 示例用法
    public static void main(String[] args) {
        DishSalesRanking ranking = new DishSalesRanking();
        ranking.recordDishSale("Pizza", 150);
        ranking.recordDishSale("Burger", 120);
        ranking.recordDishSale("Pasta", 90);
        ranking.printTopSellingDishes(2);
    }
}
