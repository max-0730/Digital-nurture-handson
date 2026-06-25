package com.cognizant;

public class UserManager {

    private LoggerService loggerService;

    public UserManager(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    public void addUser(String username) {
        loggerService.log("User Added: " + username);
    }
}