package com.designpatterns.creational.factory.abstractfactory;

/**
 * Abstract product interface for Button components.
 */
public interface Button {
    void render();
    void onClick();
    String getStyle();
} 