package com.designpatterns.behavioral.observer;

/**
 * Observer interface that defines the contract for all observers.
 * Observers are notified when the subject's state changes.
 */
public interface Observer {
    
    /**
     * Called when the subject's state changes.
     * 
     * @param message the notification message
     */
    void update(String message);
} 