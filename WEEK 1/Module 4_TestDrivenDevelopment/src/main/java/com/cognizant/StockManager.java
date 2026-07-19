package com.cognizant;

public class StockManager {

    private StockService stockService;

    public StockManager(StockService stockService) {
        this.stockService = stockService;
    }

    public String checkStock() {
        return stockService.getStockStatus();
    }
}