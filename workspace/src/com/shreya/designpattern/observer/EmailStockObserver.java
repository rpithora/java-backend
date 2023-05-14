package com.shreya.designpattern.observer;

import com.shreya.designpattern.observer.observable.StockObservable;

public class EmailStockObserver implements StockObserver{

    StockObservable stockObservable = null;

    public EmailStockObserver(StockObservable stockObservable){
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        System.out.println("Email Notified...");
    }
}
