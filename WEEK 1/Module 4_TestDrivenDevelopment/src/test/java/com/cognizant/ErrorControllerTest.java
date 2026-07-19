package com.cognizant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ErrorController.class)
@Import(GlobalExceptionHandler.class)
public class ErrorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testExceptionHandling()
            throws Exception {

        mockMvc.perform(get("/error-test"))
                .andExpect(status().isBadRequest())
                .andExpect(content()
                        .string("Something went wrong"));
    }
}