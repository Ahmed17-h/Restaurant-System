package com.restaurant.discount;

import com.restaurant.order.Order;

public class PizzaDiscount implements IDiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        long pizzaCount = order.getItems().stream()
            .filter(i -> "Pizza".equals(i.getCategory()))
            .count();
        return pizzaCount >= 2 ? order.getSubtotal() * 0.15 : 0;
    }
}