package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Test
    void testInvalidProductId() {

        ProductService service =
                new ProductService();

        Exception exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> service.getProduct(0)
                );

        assertEquals(
                "Invalid Product ID",
                exception.getMessage()
        );
    }
}