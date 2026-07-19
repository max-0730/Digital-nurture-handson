package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @Test
    void testAdd() {

        CalculatorService service =
                new CalculatorService();

        assertEquals(10,
                service.add(4, 6));
    }
}