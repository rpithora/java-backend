package com.shreya.designpattern.observer.observable;

import com.shreya.designpattern.observer.StockObserver;

public interface StockObservable {
    void add(StockObserver observer);
    void remove(StockObserver observer);
    void notifyMe();
    void setCurrentStock(int stock);
}
