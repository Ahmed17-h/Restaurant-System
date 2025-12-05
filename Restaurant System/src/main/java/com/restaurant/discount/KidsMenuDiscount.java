package com.restaurant.discount;

import com.restaurant.order.Order;

public class KidsMenuDiscount implements IDiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        boolean hasKidsItem = order.getItems().stream()
            .anyMatch(item -> "Kids".equals(item.getCategory()));
        return hasKidsItem ? order.getSubtotal() * 0.10 : 0; // 10% discount on kids menu
    }
}