package com.cognizant;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceSpringTest {

    @Test
    void testGetUserById() {

        UserRepositorySpring repository =
                mock(UserRepositorySpring.class);

        UserEntity user =
                new UserEntity(1L, "John");

        when(repository.findById(1L))
                .thenReturn(Optional.of(user));

        UserServiceSpring service =
                new UserServiceSpring(repository);

        UserEntity result =
                service.getUserById(1L);

        assertEquals("John", result.getName());
    }
}