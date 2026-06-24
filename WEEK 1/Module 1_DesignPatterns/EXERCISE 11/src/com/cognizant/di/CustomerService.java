package com.cognizant.di;

public class CustomerService {

    private CustomerRepository customerRepository;

    // Constructor Injection (DI)
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void showCustomer(int id) {

        Customer customer = customerRepository.findCustomerById(id);

        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Name: " + customer.getName());

    }

}