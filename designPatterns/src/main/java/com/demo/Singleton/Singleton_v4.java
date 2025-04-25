package com.demo.Singleton;// In Java, there is a simpler and more efficient way to implement a singleton using the Bill Pugh Singleton Design Pattern.
// This pattern uses a static inner class to hold the instance of the singleton.
// The static inner class is not loaded until it is referenced, which means that the instance is not created until it is needed.
// This approach is thread-safe and does not require synchronization.

// The implementation is as follows:
public class Singleton_v4 {
    // Private constructor to prevent instantiation
    private Singleton_v4() {}

    // Static inner class to hold the instance of the singleton
    private static class SingletonHelper {
        // Static instance of the singleton
        private static final Singleton_v4 INSTANCE = new Singleton_v4();
    }

    // Public method to provide access to the instance
    public static Singleton_v4 getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

