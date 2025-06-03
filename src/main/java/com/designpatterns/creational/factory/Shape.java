package com.designpatterns.creational.factory;

/**
 * Common interface for all shapes.
 * This interface defines the contract that all concrete shapes must implement.
 */
public interface Shape {
    
    /**
     * Draws the shape.
     */
    void draw();
    
    /**
     * Calculates the area of the shape.
     * 
     * @return the area of the shape
     */
    double calculateArea();
    
    /**
     * Gets the type of the shape.
     * 
     * @return the shape type as a string
     */
    String getType();
} 