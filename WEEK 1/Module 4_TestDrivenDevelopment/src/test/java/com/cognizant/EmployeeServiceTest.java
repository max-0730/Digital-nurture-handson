package com.cognizant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    EmployeeRepository repository;

    @Test
    void testMockAnnotation() {

        when(repository.getEmployeeName())
                .thenReturn("John");

        EmployeeService service =
                new EmployeeService(repository);

        assertEquals(
                "John",
                service.fetchEmployeeName()
        );
    }
}