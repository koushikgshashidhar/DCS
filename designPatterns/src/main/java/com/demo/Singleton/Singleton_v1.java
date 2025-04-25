package com.demo.Singleton;

public class Singleton_v1 {
    // Private static instance of the class
    private static Singleton_v1 instance;
public static void main(String []args)
{

}
    // Private constructor to prevent instantiation
    private Singleton_v1() {}

    // Public method to provide access to the instance
    public static Singleton_v1 getInstance() {
        if (instance == null) {
            instance = new Singleton_v1();
        }
        return instance;
    }
}

//what if two threads call getInstance() at the same time?
// In this case, both threads will see that instance is null and will create a new instance of Singleton_v1.
// This can lead to multiple instances of the Singleton_v1 class being created, which violates the singleton pattern.
// To fix this, we can use the synchronized keyword to make the getInstance() method thread-safe.
