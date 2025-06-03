package com.designpatterns.creational.factory;

/**
 * Concrete implementation of Shape interface for Circle.
 */
public class Circle implements Shape {
    
    private final double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius: " + radius);
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public String getType() {
        return "Circle";
    }
    
    public double getRadius() {
        return radius;
    }
} 