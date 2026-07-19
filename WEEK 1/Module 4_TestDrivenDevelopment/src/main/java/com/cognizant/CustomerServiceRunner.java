package com.cognizant;

public class CustomerServiceRunner {

    public static void main(String[] args) {

        CustomerService service = new CustomerService();

        service.getCustomer("John");

        service.getCustomer("");
    }
}