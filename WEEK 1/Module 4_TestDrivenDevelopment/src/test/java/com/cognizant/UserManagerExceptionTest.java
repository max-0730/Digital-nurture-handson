package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UserManagerExceptionTest {

    @Test
    void testVoidMethodException() {

        LoggerService mockLogger =
                mock(LoggerService.class);

        doThrow(new RuntimeException("Logging Failed"))
                .when(mockLogger)
                .log(anyString());

        UserManager manager =
                new UserManager(mockLogger);

        assertThrows(
                RuntimeException.class,
                () -> manager.addUser("John")
        );
    }
}