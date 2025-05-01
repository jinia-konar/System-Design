package service.impl;

import service.PaymentMethod;

public class CardPaymentMethod implements PaymentMethod {
    @Override
    public void processPayment(int price) {
        System.out.println("Payment processed via Card for amount: " + price);
    }
}
