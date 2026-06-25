package com.cognizant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserManager2Test {

    @Mock
    UserDao dao;

    @InjectMocks
    UserManager2 manager;

    @Test
    void testArgumentCaptor() {

        manager.register("John");

        ArgumentCaptor<String> captor =
                ArgumentCaptor.forClass(String.class);

        verify(dao).save(captor.capture());

        assertEquals(
                "John",
                captor.getValue()
        );
    }
}