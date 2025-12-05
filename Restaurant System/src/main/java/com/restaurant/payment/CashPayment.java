// CashPayment.java
package com.restaurant.payment;
public class CashPayment implements IPaymentMethod {
    @Override public boolean processPayment(double amount) {
        System.out.println("Paid EGP " + String.format("%.2f", amount) + " in Cash.");
        return true;
    }
}