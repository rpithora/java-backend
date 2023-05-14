package com.shreya.designpattern.abstractfactory.chair;

public class ModernChair implements Chair{
    @Override
    public void hasLegs() {
        System.out.println("Modern Chair");
    }
}
