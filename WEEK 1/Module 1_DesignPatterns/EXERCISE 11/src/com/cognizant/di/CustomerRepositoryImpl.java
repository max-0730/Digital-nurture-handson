package com.cognizant.di;

public class CustomerRepositoryImpl implements CustomerRepository {

    public Customer findCustomerById(int id) {

        // dummy data (like database)
        return new Customer(id, "Meghana User");

    }

}