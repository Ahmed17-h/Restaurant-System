package com.restaurant.payment;

public class MobileWalletPayment implements IPaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Paid EGP " + String.format("%.2f", amount) + " via Mobile Wallet.");
        return true;
    }
}