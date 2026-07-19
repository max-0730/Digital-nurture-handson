package com.cognizant.proxy;

public class ProxyTest {

    public static void main(String[] args) {

        Image image1 = new ProxyImage("photo1.jpg");

        // first call → loads image
        image1.display();

        System.out.println();

        // second call → does NOT load again (cached)
        image1.display();

    }
}