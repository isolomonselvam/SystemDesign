package com.designpatterns.structural.decorator;

/**
 * Concrete Decorator - Adds sugar to coffee.
 * Implements the abstract methods to provide sugar-specific behavior.
 */
public class SugarDecorator extends CoffeeDecorator {
    
    private static final double SUGAR_COST = 0.25;
    
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }
    
    @Override
    public double getCost() {
        return coffee.getCost() + SUGAR_COST;
    }
} 