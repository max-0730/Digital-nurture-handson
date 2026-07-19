package com.cognizant.strategy;

public class StrategyTest {

    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        // Credit Card payment
        context.setStrategy(new CreditCardPayment());
        context.executePayment(1000);

        // PayPal payment
        context.setStrategy(new PayPalPayment());
        context.executePayment(2000);

    }

}