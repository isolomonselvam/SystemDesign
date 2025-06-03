package com.designpatterns.structural.decorator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Decorator pattern with proper abstract implementation.
 */
class CoffeeDecoratorTest {

    @Test
    @DisplayName("Should create simple coffee with correct description and cost")
    void testSimpleCoffee() {
        Coffee coffee = new SimpleCoffee();
        
        assertEquals("Simple Coffee", coffee.getDescription());
        assertEquals(2.00, coffee.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should create simple tea with correct description and cost")
    void testSimpleTea() {
        Coffee tea = new SimpleTea();
        
        assertEquals("Simple Tea", tea.getDescription());
        assertEquals(1.50, tea.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should add milk decorator to tea correctly")
    void testMilkDecoratorOnTea() {
        Coffee tea = new MilkDecorator(new SimpleTea());
        
        assertEquals("Simple Tea, Milk", tea.getDescription());
        assertEquals(2.00, tea.getCost(), 0.01); // 1.50 + 0.50
    }

    @Test
    @DisplayName("Should add milk decorator correctly")
    void testMilkDecorator() {
        Coffee coffee = new MilkDecorator(new SimpleCoffee());
        
        assertEquals("Simple Coffee, Milk", coffee.getDescription());
        assertEquals(2.50, coffee.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should add sugar decorator correctly")
    void testSugarDecorator() {
        Coffee coffee = new SugarDecorator(new SimpleCoffee());
        
        assertEquals("Simple Coffee, Sugar", coffee.getDescription());
        assertEquals(2.25, coffee.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should add whip decorator correctly")
    void testWhipDecorator() {
        Coffee coffee = new WhipDecorator(new SimpleCoffee());
        
        assertEquals("Simple Coffee, Whipped Cream", coffee.getDescription());
        assertEquals(2.75, coffee.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should chain multiple decorators correctly")
    void testMultipleDecorators() {
        Coffee coffee = new WhipDecorator(
            new SugarDecorator(
                new MilkDecorator(
                    new SimpleCoffee()
                )
            )
        );
        
        assertEquals("Simple Coffee, Milk, Sugar, Whipped Cream", coffee.getDescription());
        assertEquals(3.50, coffee.getCost(), 0.01); // 2.00 + 0.50 + 0.25 + 0.75
    }

    @Test
    @DisplayName("Should allow same decorator multiple times")
    void testSameDecoratorMultipleTimes() {
        Coffee coffee = new MilkDecorator(
            new MilkDecorator(
                new SimpleCoffee()
            )
        );
        
        assertEquals("Simple Coffee, Milk, Milk", coffee.getDescription());
        assertEquals(3.00, coffee.getCost(), 0.01); // 2.00 + 0.50 + 0.50
    }

    @Test
    @DisplayName("Should work with mixed beverages and decorators")
    void testMixedBeveragesAndDecorators() {
        // Fancy tea with multiple decorators
        Coffee fancyTea = new WhipDecorator(
            new SugarDecorator(
                new SimpleTea()
            )
        );
        
        assertEquals("Simple Tea, Sugar, Whipped Cream", fancyTea.getDescription());
        assertEquals(2.50, fancyTea.getCost(), 0.01); // 1.50 + 0.25 + 0.75
        
        // Compare with fancy coffee
        Coffee fancyCoffee = new WhipDecorator(
            new SugarDecorator(
                new SimpleCoffee()
            )
        );
        
        assertEquals("Simple Coffee, Sugar, Whipped Cream", fancyCoffee.getDescription());
        assertEquals(3.00, fancyCoffee.getCost(), 0.01); // 2.00 + 0.25 + 0.75
    }

    @Test
    @DisplayName("Should throw exception when coffee is null")
    void testNullCoffeeValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MilkDecorator(null);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            new SugarDecorator(null);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            new WhipDecorator(null);
        });
    }

    @Test
    @DisplayName("Should verify constants are used correctly")
    void testDecoratorConstants() {
        Coffee baseCoffee = new SimpleCoffee();
        
        // Test that each decorator adds the correct amount
        Coffee milkCoffee = new MilkDecorator(baseCoffee);
        assertEquals(0.50, milkCoffee.getCost() - baseCoffee.getCost(), 0.01);
        
        Coffee sugarCoffee = new SugarDecorator(baseCoffee);
        assertEquals(0.25, sugarCoffee.getCost() - baseCoffee.getCost(), 0.01);
        
        Coffee whipCoffee = new WhipDecorator(baseCoffee);
        assertEquals(0.75, whipCoffee.getCost() - baseCoffee.getCost(), 0.01);
    }
} 