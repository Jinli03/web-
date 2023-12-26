import java.util.HashMap;
import java.util.Map;

class Inventory {
    private Map<String, Integer> stock;

    public Inventory() {
        stock = new HashMap<>();
    }

    public void addStock(String item, int quantity) {
        stock.put(item, stock.getOrDefault(item, 0) + quantity);
    }

    public boolean sellItem(String item, int quantity) {
        if (stock.getOrDefault(item, 0) >= quantity) {
            stock.put(item, stock.get(item) - quantity);
            return true;
        }
        return false;
    }

    public void printInventory() {
        System.out.println("Inventory Stock:");
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // 示例用法
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addStock("Apple", 50);
        inventory.addStock("Banana", 30);

        inventory.sellItem("Apple", 10);
        inventory.printInventory();
    }
}
