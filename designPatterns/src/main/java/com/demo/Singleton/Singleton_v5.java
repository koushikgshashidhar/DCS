package com.demo.Singleton;

enum Singleton_v5 {
    INSTANCE;

    // Add any other methods or fields you need here
    public void someMethod() {
        // Implementation of the method

    }
    public static void main(String[] args) {
        // Access the singleton instance
        Singleton_v5 singleton = Singleton_v5.INSTANCE;

        // Call a method on the singleton instance
        singleton.someMethod();
    }
}

//enum implementation solves serialization, deserialization , reflection, multiple classloader issues
// The enum type is inherently serializable, and the JVM ensures that only one instance of the enum is created.
// This means that even if the singleton is serialized and deserialized, it will still refer to the same instance.
// The enum type also prevents the creation of multiple instances through reflection.
// The JVM ensures that the enum type is loaded only once, even if multiple class loaders are used.
