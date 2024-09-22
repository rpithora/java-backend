package com.shreya.designpattern.behavioral.observer;

import com.shreya.designpattern.behavioral.observer.observable.StockObservable;

public class MobileStockObserver implements StockObserver{
    StockObservable stockObservable = null;

    public MobileStockObserver(StockObservable stockObservable){
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        System.out.println("Mobile Notified");
    }
}
