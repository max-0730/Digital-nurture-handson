package com.cognizant.builder;


public class BuilderTest {


public static void main(String[] args){



    Computer computer1 =
            new Computer.Builder()
            .setCpu("Intel i7")
            .setRam(16)
            .setStorage(512)
            .setGraphicsCard("Nvidia RTX")
            .build();



    computer1.display();




    System.out.println();



    Computer computer2 =
            new Computer.Builder()
            .setCpu("AMD Ryzen")
            .setRam(8)
            .setStorage(256)
            .build();



    computer2.display();



}



}