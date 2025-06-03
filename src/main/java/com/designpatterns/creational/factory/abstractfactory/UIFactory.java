package com.designpatterns.creational.factory.abstractfactory;

/**
 * Abstract Factory interface for creating families of related UI components.
 * This demonstrates the Abstract Factory pattern which provides an interface
 * for creating families of related or dependent objects.
 */
public interface UIFactory {
    
    /**
     * Creates a button component.
     * @return a Button instance
     */
    Button createButton();
    
    /**
     * Creates a text field component.
     * @return a TextField instance
     */
    TextField createTextField();
    
    /**
     * Creates a checkbox component.
     * @return a Checkbox instance
     */
    Checkbox createCheckbox();
} 