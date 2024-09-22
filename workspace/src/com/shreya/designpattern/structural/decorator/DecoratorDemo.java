package com.shreya.designpattern.structural.decorator;

import com.shreya.designpattern.structural.decorator.troppings.ExtraCheese;
import com.shreya.designpattern.structural.decorator.troppings.Mushrooms;

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
