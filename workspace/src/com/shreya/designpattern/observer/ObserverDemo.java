package com.shreya.designpattern.observer;

import com.shreya.designpattern.observer.observable.IPhoneStockObservable;
import com.shreya.designpattern.observer.observable.StockObservable;

public class ObserverDemo {
    public static void main(String[] args) {

        StockObservable iPhoneStockObservable = new IPhoneStockObservable();

        StockObserver observer1 = new MobileStockObserver(iPhoneStockObservable);
        StockObserver observer2 = new EmailStockObserver(iPhoneStockObservable);
        StockObserver observer3 = new EmailStockObserver(iPhoneStockObservable);

        iPhoneStockObservable.add(observer1);
        iPhoneStockObservable.add(observer2);
        iPhoneStockObservable.add(observer3);

        iPhoneStockObservable.setCurrentStock(10);
    }
}
