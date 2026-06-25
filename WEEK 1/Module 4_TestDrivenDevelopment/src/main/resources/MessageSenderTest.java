package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class MessageSenderTest {

    @Test
    void testArgumentMatching() {

        // Create Mock
        NotificationService mockService =
                mock(NotificationService.class);

        // Inject Mock
        MessageSender sender =
                new MessageSender(mockService);

        // Execute
        sender.send("Welcome User");

        // Verify using Argument Matcher
        verify(mockService).sendNotification(anyString());
    }
}