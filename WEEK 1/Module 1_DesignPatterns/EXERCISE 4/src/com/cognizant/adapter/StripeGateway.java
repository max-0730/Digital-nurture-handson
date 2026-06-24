package com.cognizant.adapter;


public class StripeGateway {


    public void payAmount(double money){


        System.out.println(
        "Payment done using Stripe : ₹" + money
        );


    }


}