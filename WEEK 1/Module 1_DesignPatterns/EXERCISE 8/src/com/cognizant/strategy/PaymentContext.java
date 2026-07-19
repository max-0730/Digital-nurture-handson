package com.cognizant.strategy;

public class PaymentContext {

    private PaymentStrategy strategy;

    // set strategy at runtime
    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(int amount) {
        strategy.pay(amount);
    }

}