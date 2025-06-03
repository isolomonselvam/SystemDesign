package com.designpatterns.structural.decorator;

/**
 * Concrete Component - Basic tea implementation.
 * Demonstrates that different beverages can implement the same interface.
 */
public class SimpleTea implements Coffee {
    
    @Override
    public String getDescription() {
        return "Simple Tea";
    }
    
    @Override
    public double getCost() {
        return 1.50;
    }
} 