package com.shreya.designpattern.behavioral.observer.observable;

import com.shreya.designpattern.behavioral.observer.StockObserver;

public interface StockObservable {
    void add(StockObserver observer);
    void remove(StockObserver observer);
    void notifyMe();
    void setCurrentStock(int stock);
}
