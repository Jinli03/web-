package good;

import java.util.HashMap;
import java.util.Map;

class EtherealFoodWasteTracker {
    private Map<String, Double> wastedIngredients;

    public EtherealFoodWasteTracker() {
        this.wastedIngredients = new HashMap<>();
    }

    public void recordWaste(String ingredient, double quantity) {
        wastedIngredients.put(ingredient, wastedIngredients.getOrDefault(ingredient, 0.0) + quantity);
    }

    public void printWasteReport() {
        System.out.println("Food Waste Report:");
        double totalWaste = 0.0;
        for (Map.Entry<String, Double> entry : wastedIngredients.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " kg/liters");
            totalWaste += entry.getValue();
        }
        System.out.println("Total Waste: " + totalWaste + " kg/liters");
    }

    // 示例用法
    public static void main(String[] args) {
        EtherealFoodWasteTracker tracker = new EtherealFoodWasteTracker();
        tracker.recordWaste("Tomatoes", 2.5);
        tracker.recordWaste("Lettuce", 1.0);
        tracker.recordWaste("Bread", 0.5);
        tracker.printWasteReport();
    }
}
