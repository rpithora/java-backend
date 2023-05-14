package com.shreya.designpattern.abstractfactory;

import com.shreya.designpattern.abstractfactory.FurnitureFactory;
import com.shreya.designpattern.abstractfactory.chair.Chair;
import com.shreya.designpattern.abstractfactory.chair.ModernChair;
import com.shreya.designpattern.abstractfactory.sofa.ModernSofa;
import com.shreya.designpattern.abstractfactory.sofa.Sofa;

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
