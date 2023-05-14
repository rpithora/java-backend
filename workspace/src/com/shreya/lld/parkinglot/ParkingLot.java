package com.shreya.lld.parkinglot;

import com.shreya.lld.parkinglot.model.Vehicle;

public interface ParkingLot {
    int id = 0;
    Vehicle vehicle = null;
    boolean isReserved = false;

    public void reserve();
    public void remove();
    public void price();
}
