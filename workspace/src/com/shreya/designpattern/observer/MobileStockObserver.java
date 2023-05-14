package com.shreya.designpattern.observer;

import com.shreya.designpattern.observer.observable.StockObservable;

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
