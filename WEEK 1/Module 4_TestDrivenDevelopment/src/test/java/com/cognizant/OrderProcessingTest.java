package com.cognizant;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class OrderProcessingTest {

    @Test
    void testMethodOrder() {

        OrderProcessingService service =
                mock(OrderProcessingService.class);

        service.validate();
        service.process();
        service.complete();

        InOrder inOrder =
                inOrder(service);

        inOrder.verify(service).validate();
        inOrder.verify(service).process();
        inOrder.verify(service).complete();
    }
}