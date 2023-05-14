package com.shreya.designpattern.abstractfactory.chair;

public class ArtChair implements Chair{
    @Override
    public void hasLegs() {
        System.out.println("Art Chair");
    }
}
