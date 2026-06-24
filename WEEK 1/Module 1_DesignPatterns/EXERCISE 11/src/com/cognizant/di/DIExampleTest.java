package com.cognizant.di;

public class DIExampleTest {

    public static void main(String[] args) {

        // create repository object
        CustomerRepository repo = new CustomerRepositoryImpl();

        // inject dependency into service
        CustomerService service = new CustomerService(repo);

        // use service
        service.showCustomer(101);

    }

}