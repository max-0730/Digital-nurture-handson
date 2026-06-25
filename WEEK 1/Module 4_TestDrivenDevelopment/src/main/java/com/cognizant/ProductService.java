package com.cognizant;

public class ProductService {

    public String getProduct(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Invalid Product ID");
        }

        return "Laptop";
    }
}