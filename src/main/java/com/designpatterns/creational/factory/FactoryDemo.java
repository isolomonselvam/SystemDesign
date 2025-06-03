package com.designpatterns.creational.factory;

/**
 * Demo class to demonstrate the Factory pattern usage.
 */
public class FactoryDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Factory Pattern Demo ===\n");
        
        try {
            // Create different shapes using the factory
            System.out.println("Creating shapes using ShapeFactory:");
            
            // Create a circle
            Shape circle = ShapeFactory.createCircle(5.0);
            circle.draw();
            System.out.println("Area: " + circle.calculateArea());
            System.out.println("Type: " + circle.getType());
            System.out.println();
            
            // Create a rectangle
            Shape rectangle = ShapeFactory.createRectangle(4.0, 6.0);
            rectangle.draw();
            System.out.println("Area: " + rectangle.calculateArea());
            System.out.println("Type: " + rectangle.getType());
            System.out.println();
            
            // Create shapes using the generic factory method
            System.out.println("Creating shapes using generic factory method:");
            
            Shape anotherCircle = ShapeFactory.createShape(ShapeFactory.ShapeType.CIRCLE, 3.0);
            anotherCircle.draw();
            System.out.println("Area: " + anotherCircle.calculateArea());
            System.out.println();
            
            Shape anotherRectangle = ShapeFactory.createShape(ShapeFactory.ShapeType.RECTANGLE, 2.0, 8.0);
            anotherRectangle.draw();
            System.out.println("Area: " + anotherRectangle.calculateArea());
            System.out.println();
            
            // Demonstrate error handling
            System.out.println("Testing error handling:");
            try {
                Shape triangle = ShapeFactory.createShape(ShapeFactory.ShapeType.TRIANGLE, 3.0, 4.0, 5.0);
                triangle.draw();
            } catch (UnsupportedOperationException e) {
                System.out.println("Expected error: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.err.println("Error in Factory Demo: " + e.getMessage());
        }
    }
} 