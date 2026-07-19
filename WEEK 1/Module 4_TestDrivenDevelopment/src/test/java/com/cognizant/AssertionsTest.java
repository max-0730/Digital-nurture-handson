package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void testAssertions() {

        // assertEquals
        assertEquals(5, 2 + 3);

        // assertTrue
        assertTrue(5 > 3);

        // assertFalse
        assertFalse(5 < 3);

        // assertNull
        assertNull(null);

        // assertNotNull
        assertNotNull(new Object());
    }
}