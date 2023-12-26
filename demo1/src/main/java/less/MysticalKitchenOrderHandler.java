package good;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

class MysticalKitchenOrderHandler {
    private Queue<String> orderQueue;
    private Map<String, Integer> dishPreparationTime;

    public MysticalKitchenOrderHandler() {
        orderQueue = new LinkedList<>();
        dishPreparationTime = new HashMap<>();
    }

    public void addDishPreparationTime(String dishName, int time) {
        dishPreparationTime.put(dishName, time);
    }

    public void receiveOrder(String order) {
        orderQueue.offer(order);
        System.out.println("Order received: " + order);
    }

    public void processOrders() {
        while (!orderQueue.isEmpty()) {
            String currentOrder = orderQueue.poll();
            int prepTime = dishPreparationTime.getOrDefault(currentOrder, 0);
            System.out.println("Processing: " + currentOrder + " (Preparation time: " + prepTime + " minutes)");
            // Simulating preparation time
            try {
                Thread.sleep(prepTime * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 示例用法
    public static void main(String[] args) {
        MysticalKitchenOrderHandler handler = new MysticalKitchenOrderHandler();
        handler.addDishPreparationTime("Spaghetti Bolognese", 30);
        handler.addDishPreparationTime("Margherita Pizza", 20);
        handler.receiveOrder("Spaghetti Bolognese");
        handler.receiveOrder("Margherita Pizza");
        handler.processOrders();
    }
}
