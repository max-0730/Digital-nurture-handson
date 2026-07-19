package com.cognizant.adapter;



public class AdapterTest {


public static void main(String[] args){



    PayPalGateway paypal =
            new PayPalGateway();



    PaymentProcessor processor1 =
            new PayPalAdapter(paypal);



    processor1.processPayment(500);



    StripeGateway stripe =
            new StripeGateway();



    PaymentProcessor processor2 =
            new StripeAdapter(stripe);



    processor2.processPayment(1000);



}


}