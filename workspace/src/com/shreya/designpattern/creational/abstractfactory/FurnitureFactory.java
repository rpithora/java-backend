package com.shreya.designpattern.creational.abstractfactory;

import com.shreya.designpattern.creational.abstractfactory.chair.Chair;
import com.shreya.designpattern.creational.abstractfactory.sofa.Sofa;

public interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}
