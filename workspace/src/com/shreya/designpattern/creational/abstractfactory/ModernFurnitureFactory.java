package com.shreya.designpattern.creational.abstractfactory;

import com.shreya.designpattern.creational.abstractfactory.chair.Chair;
import com.shreya.designpattern.creational.abstractfactory.chair.ModernChair;
import com.shreya.designpattern.creational.abstractfactory.sofa.ModernSofa;
import com.shreya.designpattern.creational.abstractfactory.sofa.Sofa;

public class ModernFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}
