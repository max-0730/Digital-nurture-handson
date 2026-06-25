package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UserManagerTest {

    @Test
    void testVoidMethod() {

        // Create Mock
        LoggerService mockLogger =
                mock(LoggerService.class);

        // Stub Void Method
        doNothing().when(mockLogger)
                .log(anyString());

        // Inject Mock
        UserManager manager =
                new UserManager(mockLogger);

        // Execute
        manager.addUser("John");

        // Verify
        verify(mockLogger)
                .log("User Added: John");
    }
}