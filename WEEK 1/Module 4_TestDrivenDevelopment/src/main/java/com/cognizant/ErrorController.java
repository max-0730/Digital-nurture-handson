package com.cognizant;

import org.springframework.web.bind.annotation.*;

@RestController
public class ErrorController {

    @GetMapping("/error-test")
    public String testError() {

        throw new IllegalArgumentException(
                "Something went wrong"
        );
    }
}