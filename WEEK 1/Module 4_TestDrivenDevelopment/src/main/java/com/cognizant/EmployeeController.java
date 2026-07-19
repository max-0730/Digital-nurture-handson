package com.cognizant;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @PostMapping
    public Employee createEmployee(
            @RequestBody Employee employee) {

        return employee;
    }
}