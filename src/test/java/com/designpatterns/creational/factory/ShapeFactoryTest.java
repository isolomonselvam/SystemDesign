package com.designpatterns.creational.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive tests for the Factory pattern implementation.
 */
class ShapeFactoryTest {

    @Test
    @DisplayName("Should create circle with correct properties")
    void testCreateCircle() {
        Shape circle = ShapeFactory.createCircle(5.0);
        
        assertNotNull(circle);
        assertTrue(circle instanceof Circle);
        assertEquals("Circle", circle.getType());
        assertEquals(Math.PI * 25, circle.calculateArea(), 0.01);
        
        Circle c = (Circle) circle;
        assertEquals(5.0, c.getRadius(), 0.01);
    }

    @Test
    @DisplayName("Should create rectangle with correct properties")
    void testCreateRectangle() {
        Shape rectangle = ShapeFactory.createRectangle(4.0, 6.0);
        
        assertNotNull(rectangle);
        assertTrue(rectangle instanceof Rectangle);
        assertEquals("Rectangle", rectangle.getType());
        assertEquals(24.0, rectangle.calculateArea(), 0.01);
        
        Rectangle r = (Rectangle) rectangle;
        assertEquals(4.0, r.getWidth(), 0.01);
        assertEquals(6.0, r.getHeight(), 0.01);
    }

    @Test
    @DisplayName("Should create triangle with correct properties")
    void testCreateTriangle() {
        Shape triangle = ShapeFactory.createTriangle(3.0, 4.0, 5.0);
        
        assertNotNull(triangle);
        assertTrue(triangle instanceof Triangle);
        assertEquals("Triangle", triangle.getType());
        assertEquals(6.0, triangle.calculateArea(), 0.01); // 3-4-5 right triangle area = 6
        
        Triangle t = (Triangle) triangle;
        assertEquals(3.0, t.getSideA(), 0.01);
        assertEquals(4.0, t.getSideB(), 0.01);
        assertEquals(5.0, t.getSideC(), 0.01);
    }

    @Test
    @DisplayName("Should create equilateral triangle")
    void testCreateEquilateralTriangle() {
        Shape triangle = ShapeFactory.createEquilateralTriangle(6.0);
        
        assertNotNull(triangle);
        assertTrue(triangle instanceof Triangle);
        
        Triangle t = (Triangle) triangle;
        assertEquals(6.0, t.getSideA(), 0.01);
        assertEquals(6.0, t.getSideB(), 0.01);
        assertEquals(6.0, t.getSideC(), 0.01);
        assertEquals("Equilateral", t.getTriangleType());
        
        // Area of equilateral triangle = (√3/4) * side²
        double expectedArea = (Math.sqrt(3) / 4) * 36;
        assertEquals(expectedArea, triangle.calculateArea(), 0.01);
    }

    @Test
    @DisplayName("Should create right triangle")
    void testCreateRightTriangle() {
        Shape triangle = ShapeFactory.createRightTriangle(3.0, 4.0);
        
        assertNotNull(triangle);
        assertTrue(triangle instanceof Triangle);
        
        Triangle t = (Triangle) triangle;
        assertEquals(3.0, t.getSideA(), 0.01);
        assertEquals(4.0, t.getSideB(), 0.01);
        assertEquals(5.0, t.getSideC(), 0.01); // Hypotenuse should be 5
        assertEquals(6.0, triangle.calculateArea(), 0.01); // Area = (1/2) * base * height
    }

    @Test
    @DisplayName("Should create shapes using generic factory method")
    void testGenericFactoryMethod() {
        Shape circle = ShapeFactory.createShape(ShapeFactory.ShapeType.CIRCLE, 3.0);
        Shape rectangle = ShapeFactory.createShape(ShapeFactory.ShapeType.RECTANGLE, 2.0, 8.0);
        Shape triangle = ShapeFactory.createShape(ShapeFactory.ShapeType.TRIANGLE, 5.0, 5.0, 5.0);
        
        assertEquals("Circle", circle.getType());
        assertEquals("Rectangle", rectangle.getType());
        assertEquals("Triangle", triangle.getType());
        
        assertEquals(Math.PI * 9, circle.calculateArea(), 0.01);
        assertEquals(16.0, rectangle.calculateArea(), 0.01);
        
        Triangle t = (Triangle) triangle;
        assertEquals("Equilateral", t.getTriangleType());
    }

    @Test
    @DisplayName("Should throw exception for null shape type")
    void testNullShapeType() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.createShape(null, 5.0);
        });
    }

    @Test
    @DisplayName("Should throw exception for invalid circle parameters")
    void testInvalidCircleParameters() {
        // No parameters
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.createShape(ShapeFactory.ShapeType.CIRCLE);
        });
        
        // Too many parameters
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.createShape(ShapeFactory.ShapeType.CIRCLE, 5.0, 3.0);
        });
        
        // Negative radius
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.createCircle(-5.0);
        });
        
        // Zero radius
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.createCircle(0.0);
        });
    }

    @Test
    @DisplayName("Should throw exception for invalid rectangle parameters")
    void testInvalidRectangleParameters() {
        // Wrong number of parameters
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.createShape(ShapeFactory.ShapeType.RECTANGLE, 5.0);
        });
        
        // Negative dimensions
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.createRectangle(-4.0, 6.0);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.createRectangle(4.0, -6.0);
        });
        
        // Zero dimensions
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.createRectangle(0.0, 6.0);
        });
    }

    @Test
    @DisplayName("Should throw exception for invalid triangle parameters")
    void testInvalidTriangleParameters() {
        // Wrong number of parameters
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.createShape(ShapeFactory.ShapeType.TRIANGLE, 3.0, 4.0);
        });
        
        // Invalid triangle (violates triangle inequality)
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.createTriangle(1.0, 2.0, 5.0);
        });
        
        // Negative sides
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.createTriangle(-3.0, 4.0, 5.0);
        });
        
        // Zero sides
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.createTriangle(0.0, 4.0, 5.0);
        });
    }

    @Test
    @DisplayName("Should handle triangle types correctly")
    void testTriangleTypes() {
        // Equilateral triangle
        Triangle equilateral = (Triangle) ShapeFactory.createEquilateralTriangle(5.0);
        assertEquals("Equilateral", equilateral.getTriangleType());
        
        // Isosceles triangle
        Triangle isosceles = (Triangle) ShapeFactory.createTriangle(5.0, 5.0, 8.0);
        assertEquals("Isosceles", isosceles.getTriangleType());
        
        // Scalene triangle
        Triangle scalene = (Triangle) ShapeFactory.createTriangle(3.0, 4.0, 5.0);
        assertEquals("Scalene", scalene.getTriangleType());
    }

    @Test
    @DisplayName("Should calculate triangle perimeter correctly")
    void testTrianglePerimeter() {
        Triangle triangle = (Triangle) ShapeFactory.createTriangle(3.0, 4.0, 5.0);
        assertEquals(12.0, triangle.getPerimeter(), 0.01);
    }

    @Test
    @DisplayName("Should not draw shapes during testing")
    void testShapeDrawing() {
        // This test ensures that draw() method doesn't throw exceptions
        Shape circle = ShapeFactory.createCircle(5.0);
        Shape rectangle = ShapeFactory.createRectangle(4.0, 6.0);
        Shape triangle = ShapeFactory.createTriangle(3.0, 4.0, 5.0);
        
        assertDoesNotThrow(() -> {
            circle.draw();
            rectangle.draw();
            triangle.draw();
        });
    }
} 