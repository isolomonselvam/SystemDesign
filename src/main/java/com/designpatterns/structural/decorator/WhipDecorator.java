package com.designpatterns.structural.decorator;

/**
 * Concrete Decorator - Adds whipped cream to coffee.
 * Implements the abstract methods to provide whipped cream-specific behavior.
 */
public class WhipDecorator extends CoffeeDecorator {
    
    private static final double WHIP_COST = 0.75;
    
    public WhipDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Whipped Cream";
    }
    
    @Override
    public double getCost() {
        return coffee.getCost() + WHIP_COST;
    }
} 