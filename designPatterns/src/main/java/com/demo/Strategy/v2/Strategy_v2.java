package com.demo.Strategy.v2;

//consider if introduce fly() method in Duck base class
//but this is not a good idea because not all ducks can fly
//for example, rubber duck cannot fly
// but can we implement fly() method in Duck class and override it in subclasses?
// The answer is yes, but it is not a good design.
// any new duck that cannot fly will have to override the fly() method and provide an empty implementation.
// what if we have interface Flyable and only ducks that can fly will implement this interface
// but this is not a good design either as we have to implement the fly() method in all subclasses
//and we might have duplicate code in all subclasses and no reusability
// what if there is a small change in the fly() method, we have to change it in all subclasses
//so lets separate things that vary from those that stay the same
// so lets have concrete classes that implement the Flyable interface
// and we will have a reference to the Flyable interface in the Duck class
// so we program to an interface and not to an implementation
// so we can have different implementations of the Flyable interface and we can change the implementation at runtime
//  composition over inheritance : as the flying behaviour is not a part of the duck class which brings more flexibility
// we can concrete duck classes derived from Duck class and use composition to add flying behaviour
//so the concrete duck can change its flying behaviour at runtime
//so this is the strategy pattern
// The Strategy Pattern is useful when you have multiple algorithms for a specific task and you want to choose one at runtime.
// The pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.
// it makes the code maintainable and easy to extend.
// consider we are implementing a new duck that can fly in a different way
// we create a new class that implements the Flyable interface and we can create a new duck class that uses this new flying behaviour
//what if we want to chang flying behaviour concrete class,then we change only at one place


public class Strategy_v2 {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.quack();
        duck.fly();

        Duck rubberDuck = new RubberDuck();
        rubberDuck.quack();
        rubberDuck.fly();
    }
}

abstract class Duck
{
    public void quack()
    {
        System.out.println("I can quack");
    }

    public void  fly()
    {
        System.out.println("I can fly");
    }
}

class MallardDuck extends Duck
{
}

class RubberDuck extends Duck {

    @Override
    public void  fly()
    {
        System.out.println("dont fly");
    }
}

class BlueDuck extends Duck {

    @Override
    public void  fly()
    {
        System.out.println("I can fly");
    }
}