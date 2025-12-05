// Receipt.java
package com.restaurant.billing;
import com.restaurant.order.Order;
import com.restaurant.items.IMenuItem;

public class Receipt {
    private Order order;
    private double discount;

    public Receipt(Order order, double discount) {
        this.order = order;
        this.discount = discount;
    }

    public void print() {
        System.out.println("\n=== FINAL RECEIPT ===");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Type: " + order.getOrderType());
        System.out.println("Items:");
        for (IMenuItem item : order.getItems()) {
            System.out.println("  - " + item.getDescription() + " EGP " + item.getPrice());
        }
        System.out.println("Subtotal: EGP " + String.format("%.2f", order.getSubtotal()));
        if (discount > 0) System.out.println("Discount: -EGP " + String.format("%.2f", discount));
        System.out.println("Tax (14%): EGP " + String.format("%.2f", order.getTax()));
        System.out.println("TOTAL: EGP " + String.format("%.2f", order.getTotal() - discount));
        System.out.println("Thank you!\n");
    }
}