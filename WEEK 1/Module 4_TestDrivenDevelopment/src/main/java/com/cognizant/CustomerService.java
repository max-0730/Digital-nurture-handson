package com.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerService {

    private static final Logger logger =
            LoggerFactory.getLogger(CustomerService.class);

    public void getCustomer(String customerName) {

        logger.info("Searching customer: {}", customerName);

        if(customerName == null || customerName.isEmpty()) {
            logger.error("Customer name cannot be empty");
            return;
        }

        logger.info("Customer found: {}", customerName);
    }
}