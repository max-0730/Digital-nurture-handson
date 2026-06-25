package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;

public class AccountServiceBDDTest {

    @Test
    void testBDDStyle() {

        // Given
        AccountRepository repository =
                mock(AccountRepository.class);

        given(repository.findAccountHolder())
                .willReturn("John");

        AccountService service =
                new AccountService(repository);

        // When
        String result =
                service.getAccountHolder();

        // Then
        assertEquals("John", result);

        then(repository)
                .should()
                .findAccountHolder();
    }
}