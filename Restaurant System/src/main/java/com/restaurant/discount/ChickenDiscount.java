package com.restaurant.discount;

import com.restaurant.order.Order;

public class ChickenDiscount implements IDiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        boolean hasChicken = order.getItems().stream()
            .anyMatch(i -> "Chicken".equals(i.getCategory()));
        return hasChicken ? 20.0 : 0;
    }
}