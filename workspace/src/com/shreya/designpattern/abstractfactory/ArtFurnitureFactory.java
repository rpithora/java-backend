package com.shreya.designpattern.abstractfactory;

import com.shreya.designpattern.abstractfactory.FurnitureFactory;
import com.shreya.designpattern.abstractfactory.chair.ArtChair;
import com.shreya.designpattern.abstractfactory.chair.Chair;
import com.shreya.designpattern.abstractfactory.sofa.ArtSofa;
import com.shreya.designpattern.abstractfactory.sofa.Sofa;

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
