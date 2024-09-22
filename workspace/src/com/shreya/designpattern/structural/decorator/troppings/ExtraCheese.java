package com.shreya.designpattern.structural.decorator.troppings;

import com.shreya.designpattern.structural.decorator.PizzaBase;

public class ExtraCheese extends Toppings{
    public ExtraCheese(PizzaBase base){
        super(base);
    }
    @Override
    public int cost() {
        return base.cost() + 100 ;
    }
}
