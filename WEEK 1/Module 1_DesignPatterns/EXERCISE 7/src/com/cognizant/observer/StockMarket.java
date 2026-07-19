package com.cognizant.observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {


    private List<Observer> observers = new ArrayList<>();

    private String stockName;
    private double price;



    public void setStock(String stockName, double price){

        this.stockName = stockName;
        this.price = price;

        notifyObservers();

    }



    public void registerObserver(Observer o){

        observers.add(o);

    }



    public void removeObserver(Observer o){

        observers.remove(o);

    }



    public void notifyObservers(){

        for(Observer o : observers){

            o.update(stockName, price);

        }

    }

}