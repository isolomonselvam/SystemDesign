package com.designpatterns.structural.decorator;

/**
 * Concrete Decorator - Adds milk to coffee.
 * Implements the abstract methods to provide milk-specific behavior.
 */
public class MilkDecorator extends CoffeeDecorator {
    
    private static final double MILK_COST = 0.50;
    
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }
    
    @Override
    public double getCost() {
        return coffee.getCost() + MILK_COST;
    }
} 