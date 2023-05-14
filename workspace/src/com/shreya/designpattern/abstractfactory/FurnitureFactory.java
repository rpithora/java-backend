package com.shreya.designpattern.abstractfactory;

import com.shreya.designpattern.abstractfactory.chair.Chair;
import com.shreya.designpattern.abstractfactory.sofa.Sofa;

public interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}
