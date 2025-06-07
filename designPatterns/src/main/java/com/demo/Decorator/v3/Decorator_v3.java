package com.demo.Decorator.v3;

//Decorator Pattern
// The Decorator Pattern is a structural design pattern that allows behavior/responsibilities to be added to individual objects,
// either statically or dynamically, without affecting original object structure.
//we will use form of object composition to add new functionality to an object at runtime
//by this we add responsibilities to objects without making any changes to the underlying classes
//lets take a simple example of a starbuzz coffee shop
// they are planning to add condiments to the beverages
// we have a base class Beverage and concrete classes that extend Beverage class


//2nd version
// we will add instance variables to the Beverage class to hold the condiments to represent the condiments
//here we are changing the beverage class to add condiments and cost method for condiments
//what if price of condiments changes, we have to change the existing code
// to include new condiment we have to change the Beverage class, cost method
// this is not a good design as we are changing the existing code to add new functionality
//in some scenario a condiment may not be applicable to a beverage, but still have instance variables to represent condiments
//what if we need double mocha, triple mocha, etc.


public class Decorator_v3 {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new HouseBlend();
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}

class Beverage {
    String description = "Unknown Beverage";

    boolean hasMocha = false;
    boolean hasSoy = false;
    boolean hasWhip = false;
    boolean hasSteamedMilk = false;
    boolean hasMilk = false;

    public String getDescription() {
        return description;
    }

    public double cost() {

        double cost = 0.0;
        if (hasMocha) {
            cost += 0.20;
        }
        if (hasSoy) {
            cost += 0.15;
        }
        if (hasWhip) {
            cost += 0.10;
        }
        if (hasSteamedMilk) {
            cost += 0.10;
        }
        if (hasMilk) {
            cost += 0.10;
        }
        return cost;
    }
}
class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return super.cost()+ 1.99;
    }
}
class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return super.cost()+  0.89;
    }
}
