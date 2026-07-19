package com.cognizant;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerRepositoryTest {

    @Test
    void testFindByName() {

        CustomerRepository repository =
                mock(CustomerRepository.class);

        when(repository.findByName("John"))
                .thenReturn(
                        List.of(new Customer("John"))
                );

        assertEquals(
                1,
                repository.findByName("John").size()
        );
    }
}