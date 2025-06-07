package com.demo.Decorator.v2;

//Decorator Pattern
// The Decorator Pattern is a structural design pattern that allows behavior/responsibilities to be added to individual objects,
// either statically or dynamically, without affecting original object structure.
//we will use form of object composition to add new functionality to an object at runtime
//by this we add responsibilities to objects without making any changes to the underlying classes
//lets take a simple example of a starbuzz coffee shop
// they are planning to add condiments to the beverages
// we have a base class Beverage and concrete classes that extend Beverage class


//first version
// can we create class for each combinations
// for example, EspressoWithMocha, HouseBlendWithSoy, EspressoWithWhip, HouseBlendWithMocha, HouseBlendWithWhip
// this will lead to a lot of classes and it will be difficult to maintain-class explosion
// here each cost method computes the cost of the beverage with the condiment


public class Decorator_v2 {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new HouseBlend();
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}

abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}

class EspressoWithMocha extends Beverage {
    public EspressoWithMocha() {
        description = "Espresso with Mocha";
    }

    @Override
    public double cost() {
        return 2.99;
    }
}

class HouseBlendWithSoy extends Beverage {
    public HouseBlendWithSoy() {
        description = "House Blend Coffee with Soy";
    }

    @Override
    public double cost() {
        return 1.29;
    }
}

class EspressoWithWhip extends Beverage {
    public EspressoWithWhip() {
        description = "Espresso with Whip";
    }

    @Override
    public double cost() {
        return 2.49;
    }
}
class HouseBlendWithMocha extends Beverage {
    public HouseBlendWithMocha() {
        description = "House Blend Coffee with Mocha";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}

class HouseBlendWithWhip extends Beverage {
    public HouseBlendWithWhip() {
        description = "House Blend Coffee with Whip";
    }

    @Override
    public double cost() {
        return 1.79;
    }
}