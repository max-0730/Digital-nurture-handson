package com.cognizant;

public class AccountService {

    private AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public String getAccountHolder() {
        return repository.findAccountHolder();
    }
}