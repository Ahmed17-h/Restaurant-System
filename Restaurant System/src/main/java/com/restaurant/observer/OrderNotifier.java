package com.restaurant.observer;

import com.restaurant.order.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderNotifier {
    private List<IOrderObserver> observers = new ArrayList<>();

    public void attach(IOrderObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(Order order) {
        observers.forEach(obs -> obs.update(order));
    }
}