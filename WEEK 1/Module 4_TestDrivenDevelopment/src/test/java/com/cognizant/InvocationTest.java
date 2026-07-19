package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class InvocationTest {

    @Test
    void testInvocationCount() {

        UserRepository repository =
                mock(UserRepository.class);

        repository.saveUser("John");
        repository.saveUser("John");

        verify(repository, times(2))
                .saveUser("John");
    }
}