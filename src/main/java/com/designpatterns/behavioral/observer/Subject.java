package com.designpatterns.behavioral.observer;

/**
 * Subject interface that defines the contract for all subjects.
 * Subjects maintain a list of observers and notify them of state changes.
 */
public interface Subject {
    
    /**
     * Add an observer to the list of observers.
     * 
     * @param observer the observer to add
     */
    void addObserver(Observer observer);
    
    /**
     * Remove an observer from the list of observers.
     * 
     * @param observer the observer to remove
     */
    void removeObserver(Observer observer);
    
    /**
     * Notify all observers of a state change.
     * 
     * @param message the notification message
     */
    void notifyObservers(String message);
} 