package com.demo.Strategy.v2;

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