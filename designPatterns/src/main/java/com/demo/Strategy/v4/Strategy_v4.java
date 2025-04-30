package com.demo.Strategy.v4;


//so lets separate things that vary from those that stay the same
// so lets have concrete classes that implement the Flyable interface
// and we will have a reference to the Flyable interface in the Duck class
// so we program to an interface and not to an implementation, interface means super type
// we can have different implementations of the Flyable interface and we can change the implementation at runtime
//  composition over inheritance : as the flying behaviour code  is not  part of the duck class which brings more flexibility
// we can have concrete duck classes derived from Duck class and use composition to add flying behaviour
//so the concrete duck can change its flying behaviour at runtime
// this is the strategy pattern
// The Strategy Pattern is useful when you have multiple algorithms for a specific task and you want to choose one at runtime.
// The pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.
// it makes the code maintainable and easy to extend.
// consider we are implementing a new duck that can fly in a different way
// we create a new class that implements the Flyable interface and we can create a new duck class that uses this new flying behaviour
//what if we want to chang flying behaviour concrete class,then we change only at one place


interface Flyable
{
    void fly();
}
class FlyHigh implements Flyable
{

    @Override
    public void fly() {
        System.out.println("I can fly high");
    }
}
class FlyLow implements Flyable
{

    @Override
    public void fly() {
        System.out.println("I can fly low");
    }
}

class FlyNoWay implements Flyable
{

    @Override
    public void fly() {
        System.out.println("I cant fly");
    }
}
public class Strategy_v4 {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck(new FlyHigh());
        duck.quack();
        duck.fly();

        Duck duck2 = new MallardDuck(new FlyLow());
        duck2.quack();
        duck2.fly();

        RubberDuck rubberDuck = new RubberDuck( new FlyNoWay());
        rubberDuck.quack();
        rubberDuck.fly();

        Duck blackDuck = new BlackDuck(new FlyHigh());
        blackDuck.quack();
        blackDuck.fly();
        blackDuck.setFlyable(new FlyLow());
        blackDuck.fly();

    }
}

abstract class Duck
{
    public void quack()
    {
        System.out.println("I can quack");
    }

    Flyable flyable;
    Duck(Flyable flyable)
    {
        this.flyable=flyable;
    }

      void fly()
        {
            flyable.fly();
        }
    public void setFlyable(Flyable flyable) {
        this.flyable = flyable;
    }
}

class MallardDuck extends Duck
{

    MallardDuck(Flyable flyable) {
        super(flyable);
    }
}


class RubberDuck extends Duck
{
    RubberDuck(Flyable flyable) {
        super(flyable);
    }
}


class BlackDuck extends Duck  {

    BlackDuck(Flyable flyable) {
        super(flyable);
    }


}

