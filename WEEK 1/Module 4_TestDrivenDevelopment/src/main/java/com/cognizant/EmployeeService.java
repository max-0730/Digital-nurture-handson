package com.cognizant;

public class EmployeeService {

    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public String fetchEmployeeName() {
        return repository.getEmployeeName();
    }
}