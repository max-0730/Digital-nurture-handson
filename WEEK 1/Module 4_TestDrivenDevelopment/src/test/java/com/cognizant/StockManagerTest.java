package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StockManagerTest {

    @Test
    void testMultipleReturnValues() {

        // Create Mock
        StockService mockService =
                mock(StockService.class);

        // Multiple Return Values
        when(mockService.getStockStatus())
                .thenReturn(
                        "Available",
                        "Low Stock",
                        "Out Of Stock"
                );

        StockManager manager =
                new StockManager(mockService);

        // First Call
        assertEquals(
                "Available",
                manager.checkStock()
        );

        // Second Call
        assertEquals(
                "Low Stock",
                manager.checkStock()
        );

        // Third Call
        assertEquals(
                "Out Of Stock",
                manager.checkStock()
        );
    }
}