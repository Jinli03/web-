package less;

import entity.Dish;

import java.util.*;

class Order {
    private int orderId;
    private Map<Dish, Integer> orderItems;
    private double totalAmount;

    public Order(int orderId) {
        this.orderId = orderId;
        this.orderItems = new HashMap<>();
        this.totalAmount = 0.0;
    }

    public void addItem(Dish dish, int quantity) {
        orderItems.put(dish, orderItems.getOrDefault(dish, 0) + quantity);
        totalAmount += dish.getPrice() * quantity;
    }

    public void printOrderDetails() {
        System.out.println("Order ID: " + orderId);
        for (Map.Entry<Dish, Integer> entry : orderItems.entrySet()) {
            System.out.println(entry.getKey().getName() + " x " + entry.getValue());
        }
        System.out.println("Total Amount: " + totalAmount);
    }
}

class OrderProcessing {
    private List<Order> orders;
    private int nextOrderId;

    public OrderProcessing() {
        orders = new ArrayList<>();
        nextOrderId = 1;
    }

    public Order createOrder() {
        Order order = new Order(nextOrderId++);
        orders.add(order);
        return order;
    }

    public void printAllOrders() {
        for (Order order : orders) {
            order.printOrderDetails();
            System.out.println("----------");
        }
    }

    // 示例用法
    public static void main(String[] args) {
        OrderProcessing orderProcessing = new OrderProcessing();
        Order order1 = orderProcessing.createOrder();
        order1.addItem(new Dish("Spaghetti", 8.99), 2);
        order1.addItem(new Dish("Salad", 5.49), 1);
        order1.printOrderDetails();

        Order order2 = orderProcessing.createOrder();
        order2.addItem(new Dish("Pizza", 10.99), 3);
        order2.printOrderDetails();

        orderProcessing.printAllOrders();
    }
}
