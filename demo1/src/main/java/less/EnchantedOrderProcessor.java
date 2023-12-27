package good;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

class Order {
    private final int orderId;
    private final String dishName;
    private final Date orderTime;

    public Order(int orderId, String dishName) {
        this.orderId = orderId;
        this.dishName = dishName;
        this.orderTime = new Date();
    }

    public int getOrderId() {
        return orderId;
    }

    public String getDishName() {
        return dishName;
    }

    public Date getOrderTime() {
        return orderTime;
    }
}

class EnchantedOrderProcessor {
    private final Queue<Order> orderQueue;
    private int nextOrderId;

    public EnchantedOrderProcessor() {
        orderQueue = new LinkedList<>();
        nextOrderId = 1;
    }

    public void receiveOrder(String dishName) {
        Order newOrder = new Order(nextOrderId++, dishName);
        orderQueue.offer(newOrder);
        System.out.println("Order received: " + newOrder.getOrderId() + " for " + newOrder.getDishName());
    }

    public void processNextOrder() {
        if (!orderQueue.isEmpty()) {
            Order orderToProcess = orderQueue.poll();
            System.out.println("Processing order: " + orderToProcess.getOrderId() + " - " + orderToProcess.getDishName());
        } else {
            System.out.println("No orders to process.");
        }
    }

    public void printPendingOrders() {
        System.out.println("Pending Orders:");
        for (Order order : orderQueue) {
            System.out.println(" - Order ID: " + order.getOrderId() + ", Dish: " + order.getDishName());
        }
    }

    // 示例用法
    public static void main(String[] args) {
        EnchantedOrderProcessor processor = new EnchantedOrderProcessor();
        processor.receiveOrder("Spaghetti");
        processor.receiveOrder("Pizza");
        processor.printPendingOrders();
        processor.processNextOrder();
        processor.processNextOrder();
    }
}
