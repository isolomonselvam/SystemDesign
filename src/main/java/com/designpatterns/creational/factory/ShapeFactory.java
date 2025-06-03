package com.designpatterns.creational.factory;

/**
 * Factory class for creating Shape objects.
 * This class encapsulates the object creation logic and provides a simple interface
 * for creating different types of shapes without exposing the instantiation logic.
 */
public class ShapeFactory {
    
    /**
     * Enum defining the supported shape types.
     */
    public enum ShapeType {
        CIRCLE, RECTANGLE, TRIANGLE
    }
    
    /**
     * Creates a shape based on the given type and parameters.
     * 
     * @param shapeType the type of shape to create
     * @param parameters variable arguments for shape-specific parameters
     * @return a new Shape instance
     * @throws IllegalArgumentException if the shape type is not supported or parameters are invalid
     */
    public static Shape createShape(ShapeType shapeType, double... parameters) {
        if (shapeType == null) {
            throw new IllegalArgumentException("Shape type cannot be null");
        }
        
        switch (shapeType) {
            case CIRCLE:
                if (parameters.length != 1) {
                    throw new IllegalArgumentException("Circle requires exactly 1 parameter: radius");
                }
                if (parameters[0] <= 0) {
                    throw new IllegalArgumentException("Circle radius must be positive");
                }
                return new Circle(parameters[0]);
                
            case RECTANGLE:
                if (parameters.length != 2) {
                    throw new IllegalArgumentException("Rectangle requires exactly 2 parameters: width, height");
                }
                if (parameters[0] <= 0 || parameters[1] <= 0) {
                    throw new IllegalArgumentException("Rectangle dimensions must be positive");
                }
                return new Rectangle(parameters[0], parameters[1]);
                
            case TRIANGLE:
                if (parameters.length != 3) {
                    throw new IllegalArgumentException("Triangle requires exactly 3 parameters: sideA, sideB, sideC");
                }
                // Triangle class will handle validation
                return new Triangle(parameters[0], parameters[1], parameters[2]);
                
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }
    
    /**
     * Convenience method to create a circle.
     * 
     * @param radius the radius of the circle
     * @return a new Circle instance
     */
    public static Shape createCircle(double radius) {
        return createShape(ShapeType.CIRCLE, radius);
    }
    
    /**
     * Convenience method to create a rectangle.
     * 
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @return a new Rectangle instance
     */
    public static Shape createRectangle(double width, double height) {
        return createShape(ShapeType.RECTANGLE, width, height);
    }
    
    /**
     * Convenience method to create a triangle.
     * 
     * @param sideA the first side of the triangle
     * @param sideB the second side of the triangle
     * @param sideC the third side of the triangle
     * @return a new Triangle instance
     */
    public static Shape createTriangle(double sideA, double sideB, double sideC) {
        return createShape(ShapeType.TRIANGLE, sideA, sideB, sideC);
    }
    
    /**
     * Convenience method to create an equilateral triangle.
     * 
     * @param side the length of all sides
     * @return a new Triangle instance
     */
    public static Shape createEquilateralTriangle(double side) {
        return createTriangle(side, side, side);
    }
    
    /**
     * Convenience method to create a right triangle.
     * 
     * @param base the base of the triangle
     * @param height the height of the triangle
     * @return a new Triangle instance
     */
    public static Shape createRightTriangle(double base, double height) {
        // For a right triangle, hypotenuse = √(base² + height²)
        double hypotenuse = Math.sqrt(base * base + height * height);
        return createTriangle(base, height, hypotenuse);
    }
} 