package com.shreya.designpattern.decorator.troppings;

import com.shreya.designpattern.decorator.PizzaBase;

public class Mushrooms extends Toppings{
    public Mushrooms(PizzaBase base) {
        super(base);
    }
    public int cost(){
        return base.cost() + 50;
    }
}
