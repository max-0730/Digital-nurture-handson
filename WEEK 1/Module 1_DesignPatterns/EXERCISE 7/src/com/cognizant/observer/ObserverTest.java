package com.cognizant.observer;


public class ObserverTest {

    public static void main(String[] args) {



        StockMarket market = new StockMarket();



        Observer mobile = new MobileApp();
        Observer web = new WebApp();



        market.registerObserver(mobile);
        market.registerObserver(web);



        market.setStock("TCS", 3500.50);

        System.out.println();

        market.setStock("Infosys", 1450.75);



    }

}