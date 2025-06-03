package com.designpatterns.creational.singleton;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Unit tests for ThreadSafeSingleton class.
 */
class ThreadSafeSingletonTest {

    @Test
    @DisplayName("Should return the same instance when getInstance() is called multiple times")
    void testSingletonInstance() {
        ThreadSafeSingleton instance1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton instance2 = ThreadSafeSingleton.getInstance();
        
        assertSame(instance1, instance2, "Both instances should be the same object");
        assertEquals(instance1.hashCode(), instance2.hashCode(), "Hash codes should be equal");
    }

    @Test
    @DisplayName("Should maintain singleton property in multi-threaded environment")
    void testThreadSafety() throws InterruptedException {
        final int numberOfThreads = 10;
        final Set<ThreadSafeSingleton> instances = ConcurrentHashMap.newKeySet();
        
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        
        // Submit tasks to get singleton instances
        for (int i = 0; i < numberOfThreads; i++) {
            executor.submit(() -> {
                ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
                instances.add(instance);
            });
        }
        
        executor.shutdown();
        assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS), 
                  "All threads should complete within 5 seconds");
        
        assertEquals(1, instances.size(), 
                    "Only one unique instance should exist across all threads");
    }

    @Test
    @DisplayName("Should throw exception when trying to clone singleton")
    void testCloneNotSupported() {
        ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
        
        assertThrows(CloneNotSupportedException.class, () -> {
            instance.clone();
        }, "Cloning should throw CloneNotSupportedException");
    }

    @Test
    @DisplayName("Should execute business method without errors")
    void testBusinessMethod() {
        ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
        
        assertDoesNotThrow(() -> {
            instance.doSomething();
        }, "Business method should execute without throwing exceptions");
    }
} 