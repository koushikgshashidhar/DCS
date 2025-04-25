package com.demo.Singleton;

public class Singleton_v3 {
    // Private static instance of the class
    //volatile keyword ensures that the instance variable is always read from and written to main memory,
    private volatile static Singleton_v3 instance;

    // Private constructor to prevent instantiation
    private Singleton_v3() {}

    // Public method to provide access to the instance
    public static synchronized Singleton_v3 getInstance() {
        if (instance == null) {
            // Synchronize the block to ensure that only one thread can create the instance at a time
            synchronized (Singleton_v3.class) {
                // Check again if the instance is null after acquiring the lock
                if (instance == null) {
                    // Create the instance
                    instance = new Singleton_v3();
                }
            }

        }
        return instance;

    }
}

// In this implementation, we first check if the instance is null before acquiring the lock.
// If it is null, we acquire the lock and check again to ensure that no other thread has created the instance in the meantime.
// This way, we avoid the overhead of synchronization for subsequent calls to getInstance() after the instance has been created.
// This implementation is thread-safe and has better performance than the previous implementations.
// However, it is still not the most efficient way to implement a singleton in Java.

