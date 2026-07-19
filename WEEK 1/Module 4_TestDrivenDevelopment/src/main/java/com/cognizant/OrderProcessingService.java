package com.cognizant;

public interface OrderProcessingService {

    void validate();

    void process();

    void complete();
}