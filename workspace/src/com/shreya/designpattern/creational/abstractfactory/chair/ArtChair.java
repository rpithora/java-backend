package com.shreya.designpattern.creational.abstractfactory.chair;

public class ArtChair implements Chair{
    @Override
    public void hasLegs() {
        System.out.println("Art Chair");
    }
}
