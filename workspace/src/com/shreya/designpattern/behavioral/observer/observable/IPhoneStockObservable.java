package com.shreya.designpattern.behavioral.observer.observable;

import com.shreya.designpattern.behavioral.observer.StockObserver;

import java.util.ArrayList;
import java.util.List;

public class IPhoneStockObservable implements StockObservable{

    List<StockObserver> observers = null;
    int currentStock = 0;

    public IPhoneStockObservable(){
        observers = new ArrayList<>();
    }

    @Override
    public void add(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyMe() {
        for(StockObserver observer : observers){
            observer.update();
        }
    }

    public void setCurrentStock(int stock){
        if(currentStock == 0){
            notifyMe();
        }
        currentStock+=stock;
    }
}
