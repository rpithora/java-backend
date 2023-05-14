package com.shaurya._16companies.epam;

import java.util.Optional;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;


interface TimeProvider {
    long getMillis();
}


public class CachingDataStructure {

    private int maxSize;
    private TimeProvider timeProvider;
    CachingDataStructure(TimeProvider timeProvider, int maxSize) {
        this.timeProvider = timeProvider;
        this.maxSize = maxSize;
    }

    public void put(String key, String value, long timeToLeaveInMilliseconds) {
        throw new NotImplementedException();
    }

    public Optional<String> get(String key) {
        throw new NotImplementedException();
    }

    public int size() {
        throw new NotImplementedException();
    }
}