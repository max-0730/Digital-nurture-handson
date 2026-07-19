package com.cognizant;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberUtilsTest {

    NumberUtils utils =
            new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 999})
    void testPositiveNumbers(int number) {

        assertTrue(
                utils.isPositive(number)
        );
    }
}
