package com.designpatterns.creational.factory;

/**
 * Concrete implementation of Shape interface for Rectangle.
 */
public class Rectangle implements Shape {
    
    private final double width;
    private final double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with width: " + width + " and height: " + height);
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    @Override
    public String getType() {
        return "Rectangle";
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
} 