package com.cognizant.singleton;


public class SingletonTest {

    public static void main(String[] args) {


        Logger obj1 = Logger.getInstance();

        Logger obj2 = Logger.getInstance();


        obj1.log("First logger");


        obj2.log("Second logger");


        if(obj1 == obj2)
        {
            System.out.println("Same object created");
        }
        else
        {
            System.out.println("Different objects");
        }

    }

}