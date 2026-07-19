package com.cognizant;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplierTest {

    private Multiplier multiplier;

    @BeforeEach
    void setUp() {

        multiplier = new Multiplier();

        System.out.println("Setup Executed");
    }

    @AfterEach
    void tearDown() {

        System.out.println("Cleanup Executed");
    }

    @Test
    void testMultiply() {

        // Arrange
        int num1 = 5;
        int num2 = 4;

        // Act
        int result = multiplier.multiply(num1, num2);

        // Assert
        assertEquals(20, result);
    }
}