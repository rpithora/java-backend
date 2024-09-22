package com.shreya.designpattern.structural.decorator.troppings;

import com.shreya.designpattern.structural.decorator.PizzaBase;

public abstract class Toppings extends PizzaBase {
    PizzaBase base = null;
    Toppings(PizzaBase base) {
        this.base = base;
    }
}
