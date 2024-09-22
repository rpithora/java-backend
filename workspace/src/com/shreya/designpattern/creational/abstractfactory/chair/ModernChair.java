package com.shreya.designpattern.creational.abstractfactory.chair;

public class ModernChair implements Chair{
    @Override
    public void hasLegs() {
        System.out.println("Modern Chair");
    }
}
