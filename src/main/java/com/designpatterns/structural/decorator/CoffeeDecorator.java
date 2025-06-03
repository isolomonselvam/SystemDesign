package com.designpatterns.structural.decorator;

/**
 * Abstract Decorator class that implements Coffee and contains a Coffee object.
 * This class enforces that all concrete decorators must implement their own
 * behavior rather than just delegating to the wrapped object.
 */
public abstract class CoffeeDecorator implements Coffee {
    
    protected Coffee coffee;
    
    public CoffeeDecorator(Coffee coffee) {
        if (coffee == null) {
            throw new IllegalArgumentException("Coffee cannot be null");
        }
        this.coffee = coffee;
    }
    
    // Abstract methods force each decorator to implement its own behavior
    @Override
    public abstract String getDescription();
    
    @Override
    public abstract double getCost();
} 