package com.shreya.designpattern.creational.abstractfactory;

import com.shreya.designpattern.creational.abstractfactory.chair.ArtChair;
import com.shreya.designpattern.creational.abstractfactory.chair.Chair;
import com.shreya.designpattern.creational.abstractfactory.sofa.ArtSofa;
import com.shreya.designpattern.creational.abstractfactory.sofa.Sofa;

public class ArtFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ArtChair();
    }

    @Override
    public Sofa createSofa() {
        return new ArtSofa();
    }
}
