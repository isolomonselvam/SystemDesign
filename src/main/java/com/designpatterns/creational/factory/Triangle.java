package com.designpatterns.creational.factory;

/**
 * Concrete implementation of Shape interface for Triangle.
 * Uses Heron's formula to calculate area.
 */
public class Triangle implements Shape {
    
    private final double sideA;
    private final double sideB;
    private final double sideC;
    
    public Triangle(double sideA, double sideB, double sideC) {
        validateTriangle(sideA, sideB, sideC);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle with sides: " + sideA + ", " + sideB + ", " + sideC);
    }
    
    @Override
    public double calculateArea() {
        // Using Heron's formula: Area = √(s(s-a)(s-b)(s-c))
        // where s = (a+b+c)/2 (semi-perimeter)
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
    
    @Override
    public String getType() {
        return "Triangle";
    }
    
    /**
     * Validates that the three sides can form a valid triangle.
     * Triangle inequality: sum of any two sides must be greater than the third side.
     */
    private void validateTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("All triangle sides must be positive");
        }
        
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException(
                String.format("Invalid triangle: sides %.2f, %.2f, %.2f do not satisfy triangle inequality", a, b, c)
            );
        }
    }
    
    // Getters
    public double getSideA() { return sideA; }
    public double getSideB() { return sideB; }
    public double getSideC() { return sideC; }
    
    /**
     * Get the perimeter of the triangle.
     */
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
    
    /**
     * Determine the type of triangle based on sides.
     */
    public String getTriangleType() {
        if (sideA == sideB && sideB == sideC) {
            return "Equilateral";
        } else if (sideA == sideB || sideB == sideC || sideA == sideC) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }
} 