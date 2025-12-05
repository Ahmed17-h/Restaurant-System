package com.restaurant.observer;

import com.restaurant.order.Order;

public class KitchenDisplay implements IOrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("[KITCHEN] New Order #" + order.getOrderId() + " received! Start preparing.");
    }
}