package com.cognizant;

public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public String fetchStudent() {
        return repository.getStudent();
    }
}