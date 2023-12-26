package good;

import java.util.HashMap;
import java.util.Map;

class CrypticEnergyMonitor {
    private Map<String, Integer> energyUsage;

    public CrypticEnergyMonitor() {
        energyUsage = new HashMap<>();
    }

    public void recordEnergyUsage(String appliance, int energy) {
        energyUsage.put(appliance, energyUsage.getOrDefault(appliance, 0) + energy);
    }

    public void printEnergyReport() {
        System.out.println("Kitchen Energy Usage Report:");
        energyUsage.forEach((appliance, energy) ->
                System.out.println(appliance + ": " + energy + " kWh"));
    }

    // 示例用法
    public static void main(String[] args) {
        CrypticEnergyMonitor monitor = new CrypticEnergyMonitor();
        monitor.recordEnergyUsage("Oven", 150);
        monitor.recordEnergyUsage("Refrigerator", 100);
        monitor.printEnergyReport();
    }
}
