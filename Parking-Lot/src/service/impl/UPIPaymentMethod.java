package service.impl;

import service.PaymentMethod;

public class UPIPaymentMethod implements PaymentMethod {
    @Override
    public void processPayment(int price) {
        System.out.println("Payment processed via UPI for amount: " + price);
    }
}
