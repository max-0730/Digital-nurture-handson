package com.cognizant;

public class UserServiceSpring {

    private UserRepositorySpring repository;

    public UserServiceSpring(UserRepositorySpring repository) {
        this.repository = repository;
    }

    public UserEntity getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }
}