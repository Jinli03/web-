package good;

import java.util.HashMap;
import java.util.Map;

class MysticalIngredientInventory {
    private Map<String, Double> ingredients;

    public MysticalIngredientInventory() {
        ingredients = new HashMap<>();
    }

    public void addIngredient(String name, double quantity) {
        ingredients.put(name, ingredients.getOrDefault(name, 0.0) + quantity);
    }

    public void removeIngredient(String name, double quantity) {
        if (ingredients.containsKey(name) && ingredients.get(name) >= quantity) {
            ingredients.put(name, ingredients.get(name) - quantity);
        } else {
            System.out.println("Not enough " + name + " in inventory.");
        }
    }

    public void printInventory() {
        System.out.println("Current Inventory:");
        for (String key : ingredients.keySet()) {
            System.out.println(" - " + key + ": " + ingredients.get(key));
        }
    }

    public double getIngredientQuantity(String name) {
        return ingredients.getOrDefault(name, 0.0);
    }

    // 示例用法
    public static void main(String[] args) {
        MysticalIngredientInventory inventory = new MysticalIngredientInventory();
        inventory.addIngredient("Tomato", 30.0);
        inventory.addIngredient("Cheese", 20.0);
        inventory.removeIngredient("Tomato", 5.0);
        inventory.printInventory();
    }
}
