// Order.java
package com.restaurant.order;
import com.restaurant.items.IMenuItem;
import com.restaurant.observer.OrderNotifier;
import java.util.*;

public class Order {
    private static int nextId = 1000;
    private int orderId;
    private List<IMenuItem> items = new ArrayList<>();
    private String orderType;
    private OrderNotifier notifier = new OrderNotifier();
    private static final double TAX_RATE = 0.14;

    public Order(String orderType) {
        this.orderId = nextId++;
        this.orderType = orderType;
        notifier.attach(new com.restaurant.observer.KitchenDisplay());
        notifier.attach(new com.restaurant.observer.WaiterNotification());
    }

    public void addItem(IMenuItem item) { items.add(item); }
    public double getSubtotal() { return items.stream().mapToDouble(IMenuItem::getPrice).sum(); }
    public double getTax() { return getSubtotal() * TAX_RATE; }
    public double getTotal() { return getSubtotal() + getTax(); }

    public void placeOrder() {
        System.out.println("Order #" + orderId + " placed successfully!");
        notifier.notifyObservers(this);
    }

    
    public int getOrderId() { return orderId; }
    public List<IMenuItem> getItems() { return items; }
    public String getOrderType() { return orderType; }
}