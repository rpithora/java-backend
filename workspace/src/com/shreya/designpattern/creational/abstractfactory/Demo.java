package com.shreya.designpattern.creational.abstractfactory;

import com.shreya.designpattern.creational.abstractfactory.chair.Chair;
import com.shreya.designpattern.creational.abstractfactory.sofa.Sofa;

public class Demo {
    public static void main(String[] args) {
        FurnitureFactory furnitureFactory = new ModernFurnitureFactory();
        Chair chair = furnitureFactory.createChair();
        chair.hasLegs();
        furnitureFactory = new ArtFurnitureFactory();
        Sofa sofa = furnitureFactory.createSofa();
        sofa.hasLegs();
    }
}
