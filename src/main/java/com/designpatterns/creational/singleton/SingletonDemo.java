package com.designpatterns.creational.singleton;

/**
 * Demo class to demonstrate the Singleton pattern usage.
 */
public class SingletonDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Demo ===\n");
        
        // Test single instance creation
        ThreadSafeSingleton instance1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton instance2 = ThreadSafeSingleton.getInstance();
        
        System.out.println("Instance 1 hash: " + instance1.hashCode());
        System.out.println("Instance 2 hash: " + instance2.hashCode());
        System.out.println("Are both instances the same? " + (instance1 == instance2));
        
        // Test business functionality
        System.out.println("\nTesting business functionality:");
        instance1.doSomething();
        
        // Test thread safety
        System.out.println("\nTesting thread safety:");
        testThreadSafety();
    }
    
    private static void testThreadSafety() {
        Runnable task = () -> {
            ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
            System.out.println("Thread " + Thread.currentThread().getName() + 
                             " got instance: " + instance.hashCode());
        };
        
        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");
        Thread thread3 = new Thread(task, "Thread-3");
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
} 