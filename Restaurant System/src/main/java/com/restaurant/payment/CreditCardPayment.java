package com.restaurant.payment;

public class CreditCardPayment implements IPaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Paid EGP " + String.format("%.2f", amount) + " via Credit Card.");
        return true;
    }
}