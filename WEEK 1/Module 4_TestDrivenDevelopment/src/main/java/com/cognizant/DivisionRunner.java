package com.cognizant;

public class DivisionRunner {

    public static void main(String[] args) {

        DivisionService service = new DivisionService();

        service.divide(10, 2);

        service.divide(10, 0);
    }
}