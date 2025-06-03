package com.designpatterns.structural.decorator;

/**
 * Concrete Component - Basic coffee implementation.
 */
public class SimpleCoffee implements Coffee {
    
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
    
    @Override
    public double getCost() {
        return 2.00;
    }
} 