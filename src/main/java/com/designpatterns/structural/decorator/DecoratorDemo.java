package com.designpatterns.structural.decorator;

/**
 * Simple demo class to demonstrate the Decorator pattern.
 */
public class DecoratorDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Decorator Pattern Demo ===\n");
        
        // Start with a simple coffee
        Coffee coffee = new SimpleCoffee();
        printCoffee("Basic order", coffee);
        
        System.out.println("\n" + "-".repeat(40) + "\n");
        
        // Add milk
        coffee = new MilkDecorator(coffee);
        printCoffee("Added milk", coffee);
        
        System.out.println("\n" + "-".repeat(40) + "\n");
        
        // Add sugar
        coffee = new SugarDecorator(coffee);
        printCoffee("Added sugar", coffee);
        
        System.out.println("\n" + "-".repeat(40) + "\n");
        
        // Add whipped cream
        coffee = new WhipDecorator(coffee);
        printCoffee("Added whipped cream", coffee);
        
        System.out.println("\n" + "=".repeat(40) + "\n");
        
        // Create a different combination
        Coffee fancyCoffee = new WhipDecorator(
            new SugarDecorator(
                new MilkDecorator(
                        new SimpleCoffee()
                )
            )
        );
        printCoffee("Fancy coffee (all at once)", fancyCoffee);
        
        System.out.println("\n=== Decorator Pattern Demo Complete ===");
    }
    
    private static void printCoffee(String step, Coffee coffee) {
        System.out.println("☕ " + step + ":");
        System.out.println("   Description: " + coffee.getDescription());
        System.out.println("   Cost: $" + String.format("%.2f", coffee.getCost()));
    }
} 