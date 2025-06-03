package com.designpatterns.structural.decorator;

/**
 * Component interface that defines the contract for coffee objects.
 */
public interface Coffee {
    
    /**
     * Get the description of the coffee.
     * 
     * @return coffee description
     */
    String getDescription();
    
    /**
     * Get the cost of the coffee.
     * 
     * @return coffee cost
     */
    double getCost();
} 