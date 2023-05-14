package com.shreya.designpattern.abstractfactory;

import com.shreya.designpattern.abstractfactory.chair.Chair;

public class Demo {
    public static void main(String[] args) {
        FurnitureFactory furnitureFactory = new ModernFurnitureFactory();
        Chair chair = furnitureFactory.createChair();
        chair.hasLegs();
    }
}
