package com.restaurant.payment;

public interface IPaymentMethod {
    boolean processPayment(double amount);
}