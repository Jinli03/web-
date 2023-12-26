package good;

import java.util.*;

class ArcaneIngredientTracker {
    private Map<String, Double> ingredientStock;
    private Map<String, Double> ingredientUsage;

    public ArcaneIngredientTracker() {
        ingredientStock = new HashMap<>();
        ingredientUsage = new HashMap<>();
    }

    public void addIngredient(String name, double quantity) {
        ingredientStock.put(name, ingredientStock.getOrDefault(name, 0.0) + quantity);
    }

    public void useIngredient(String name, double quantity) {
        double currentStock = ingredientStock.getOrDefault(name, 0.0);
        if (currentStock >= quantity) {
            ingredientStock.put(name, currentStock - quantity);
            ingredientUsage.put(name, ingredientUsage.getOrDefault(name, 0.0) + quantity);
        } else {
            System.out.println("Insufficient ingredient: " + name);
        }
    }

    public void printIngredientStock() {
        System.out.println("Ingredient Stock:");
        ingredientStock.forEach((name, quantity) -> System.out.println(name + ": " + quantity));
    }

    public void printIngredientUsage() {
        System.out.println("Ingredient Usage:");
        ingredientUsage.forEach((name, quantity) -> System.out.println(name + ": " + quantity));
    }

    // 示例用法
    public static void main(String[] args) {
        ArcaneIngredientTracker tracker = new ArcaneIngredientTracker();
        tracker.addIngredient("Tomato", 50.0);
        tracker.addIngredient("Cheese", 20.0);
        tracker.useIngredient("Tomato", 10.0);
        tracker.useIngredient("Cheese", 5.0);
        tracker.printIngredientStock();
        tracker.printIngredientUsage();
    }
}
