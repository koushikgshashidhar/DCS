package com.demo.Strategy.v5;



// consider we are implementing a new duck that can fly in a different way
// we create a new class that implements the Flyable interface and we can create a new duck class that uses this new flying behaviour
//what if we want to change flying behaviour concrete class,then we change only at one place


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
class FlyMedium implements Flyable
{

    @Override
    public void fly() {
        System.out.println("I can fly medium");
    }
}

class FlyNoWay implements Flyable
{

    @Override
    public void fly() {
        System.out.println("I cant fly");
    }
}
public class Strategy_v5 {
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

        Duck blueDuck = new BlueDuck(new FlyMedium());
        blueDuck.quack();
        blueDuck.fly();

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

class BlueDuck extends Duck {

    BlueDuck(Flyable flyable) {
        super(flyable);
    }
}

