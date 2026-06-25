package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    void testVerifyInteraction() {

        // Create Mock
        UserRepository mockRepository =
                mock(UserRepository.class);

        // Inject Mock
        UserService service =
                new UserService(mockRepository);

        // Execute
        service.registerUser("John");

        // Verify Method Call
        verify(mockRepository).saveUser("John");
    }
}