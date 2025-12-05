package com.restaurant.discount;

import com.restaurant.order.Order;

public interface IDiscountStrategy {
    double calculateDiscount(Order order);  // ← لازم يكون الاسم ده بالظبط
}