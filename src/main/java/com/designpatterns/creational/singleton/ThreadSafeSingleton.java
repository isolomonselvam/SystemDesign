package com.designpatterns.creational.singleton;

/**
 * Thread-safe Singleton implementation using double-checked locking.
 * This pattern ensures that only one instance of the class exists
 * throughout the application lifecycle.
 */
public class ThreadSafeSingleton {
    
    // Volatile keyword ensures that multiple threads handle the instance variable correctly
    private static volatile ThreadSafeSingleton instance;
    
    // Private constructor prevents instantiation from outside
    private ThreadSafeSingleton() {
        // Prevent reflection-based instantiation
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create instance");
        }
    }
    
    /**
     * Returns the singleton instance using double-checked locking pattern.
     * This approach reduces the overhead of acquiring a lock by first testing
     * the locking criterion without actually acquiring the lock.
     * 
     * @return the singleton instance
     */
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
    
    /**
     * Example business method
     */
    public void doSomething() {
        System.out.println("ThreadSafeSingleton is doing something...");
    }
    
    /**
     * Prevent cloning
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of singleton is not allowed");
    }
} 