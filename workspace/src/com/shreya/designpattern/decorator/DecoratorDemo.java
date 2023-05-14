package com.shreya.designpattern.decorator;

import com.shreya.designpattern.decorator.troppings.ExtraCheese;
import com.shreya.designpattern.decorator.troppings.Mushrooms;

public class DecoratorDemo {
    public static void main(String[] args) {
        PizzaBase vegDelight = new VegDelight();
        System.out.println(vegDelight.cost());
        vegDelight = new ExtraCheese(vegDelight);
        System.out.println(vegDelight.cost());
        vegDelight = new Mushrooms(vegDelight);
        System.out.println(vegDelight.cost());
    }
}
