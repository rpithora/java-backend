package com.shreya.designpattern.behavioral.observer;

import com.shreya.designpattern.behavioral.observer.observable.StockObservable;

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
