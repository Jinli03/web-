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


}
