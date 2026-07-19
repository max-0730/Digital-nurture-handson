package com.cognizant;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findByName(String name);
}