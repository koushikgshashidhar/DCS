package com.demo.Singleton;

public class Singleton_v2 {
    // Private static instance of the class
    private static Singleton_v2 instance;

    // Private constructor to prevent instantiation
    private Singleton_v2() {}

    // Public method to provide access to the instance
    public static synchronized Singleton_v2 getInstance() {
        if (instance == null) {
            instance = new Singleton_v2();
        }
        return instance;

    }
}


// This implementation is thread-safe, but it has a performance cost due to the synchronization overhead.
// If the getInstance() method is called frequently, this can lead to a performance bottleneck.
//as we needed  synchronized  for the first time while creating instance,but once the instance is created ,
// still the  later calls would have overhead
// we can have eager initalization by creating instance at the time of class loading
// but this would create instance even if we dont need it
// To avoid this, we can use a double-checked locking pattern.
// This pattern allows us to check if the instance is null before acquiring the lock,
// and then check again after acquiring the lock.