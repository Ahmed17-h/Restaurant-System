package com.restaurant.observer;

import com.restaurant.order.Order;

public interface IOrderObserver {
    void update(Order order); 
}