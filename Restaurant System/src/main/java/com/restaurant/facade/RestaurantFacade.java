// RestaurantFacade.java
package com.restaurant.facade;
import com.restaurant.factory.*;
import com.restaurant.order.Order;
import com.restaurant.discount.IDiscountStrategy;
import com.restaurant.payment.IPaymentMethod;
import com.restaurant.billing.Receipt;

public class RestaurantFacade {
    private IMenuFactory factory;

    public void selectMenu(String type) {
        factory = switch (type.toLowerCase()) {
            case "veg" -> new VegMenuFactory();
            case "nonveg" -> new NonVegMenuFactory();
            case "kids" -> new KidsMenuFactory();
            default -> throw new IllegalArgumentException("Invalid menu");
        };
        System.out.println("Selected: " + type + " Menu\n");
        factory.createMenu().display();
    }

    public Order createOrder(String type) { return new Order(type); }

    public void checkout(Order order, IDiscountStrategy discountStrategy, IPaymentMethod payment) {
        double discount = discountStrategy.calculateDiscount(order);
        double finalAmount = order.getTotal() - discount;

        new Receipt(order, discount).print();
        payment.processPayment(finalAmount);
        order.placeOrder();
    }
}