package com.demo.Decorator.v4;

//Decorator Pattern
// The Decorator Pattern is a structural design pattern that allows behavior/responsibilities to be added to individual objects,
// either statically or dynamically, without affecting original object structure.
//we will use form of object composition to add new functionality to an object at runtime
//by this we add responsibilities to objects without making any changes to the underlying classes
//lets take a simple example of a starbuzz coffee shop
// they are planning to add condiments to the beverages
// we have a base class Beverage and concrete classes that extend Beverage class

//open closed principle
//classes should be open for extension but closed for modification
//our goal is to add new functionality to the existing code without changing the existing code
//we shall decorate the Beverage class with condiments
//this will allow us to add new condiments without changing the existing code
//we will create a Decorator class that extends Beverage class
//example if we need DarkRoast with Mocha and whip
//we will create a DarkRoast object and then decorate it with Mocha and whip
//and calling cost() method will give us the cost of DarkRoast with Mocha and whip
//Decorators have the same supertype as the objects they decorate, which allows them to be used interchangeably.
//decorator adds its own behavior before or after delegating to the object it decorates.
//decorator pattern attaches additional responsibilities to an object dynamically.
//Decorators provide a flexible alternative to subclassing for extending functionality.



public class Decorator_v4 {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2); // decorating DarkRoast with Mocha
        beverage2 = new Soy(beverage2); // decorating DarkRoast with Soy=
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

 class DarkRoast extends Beverage {
     public DarkRoast() {
         description = "Dark Roast Coffee";
     }

     @Override
     public double cost() {
         return 0.99;
     }
 }

abstract class CondimentDecorator extends Beverage {
     Beverage beverage;

    public abstract String getDescription();
}

class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }
//here we delegate the getDescription() method to the beverage object
    // then we add our own description to it
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
//first we add the cost of the mocha condiment
    // then we delegate the cost() method to the beverage object
    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}


class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }
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