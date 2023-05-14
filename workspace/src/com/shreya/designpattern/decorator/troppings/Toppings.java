package com.shreya.designpattern.decorator.troppings;

import com.shreya.designpattern.decorator.PizzaBase;

public abstract class Toppings extends PizzaBase {
    PizzaBase base = null;
    Toppings(PizzaBase base) {
        this.base = base;
    }
}
