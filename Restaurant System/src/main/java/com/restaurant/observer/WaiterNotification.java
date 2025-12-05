// src/main/java/com/restaurant/observer/WaiterNotification.java
package com.restaurant.observer;

import com.restaurant.order.Order;

public class WaiterNotification implements IOrderObserver {
    @Override
    public void update(Order order) {
        String type = order.getOrderType();
        String message = switch (type) {
            case "dine-in" -> "Customer arrived for dine-in";
            case "delivery" -> "Prepare for delivery";
            case "takeaway" -> "Customer waiting for takeaway";
            default -> "Order placed";
        };
        System.out.println("[WAITER] Order #" + order.getOrderId() + " - " + message);
    }
}