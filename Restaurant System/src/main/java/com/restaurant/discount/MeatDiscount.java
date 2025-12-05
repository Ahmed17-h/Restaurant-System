package com.restaurant.discount;

import com.restaurant.order.Order;

public class MeatDiscount implements IDiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        boolean hasMeat = order.getItems().stream()
            .anyMatch(item -> "Meat".equals(item.getCategory()));
        return hasMeat ? 25.0 : 0;
    }
}