package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpyMockTest {

    @Test
    void testMock() {

        Calculator calculatorMock =
                mock(Calculator.class);

        when(calculatorMock.add(10, 20))
                .thenReturn(100);

        assertEquals(
                100,
                calculatorMock.add(10, 20)
        );
    }

    @Test
    void testSpy() {

        Calculator calculatorSpy =
                spy(new Calculator());

        when(calculatorSpy.add(10, 20))
                .thenReturn(100);

        assertEquals(
                100,
                calculatorSpy.add(10, 20)
        );

        // Real method executes
        assertEquals(
                50,
                calculatorSpy.multiply(10, 5)
        );
    }
}