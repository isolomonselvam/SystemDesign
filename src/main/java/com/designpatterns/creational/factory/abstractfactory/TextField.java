package com.designpatterns.creational.factory.abstractfactory;

/**
 * Abstract product interface for TextField components.
 */
public interface TextField {
    void render();
    void setText(String text);
    String getText();
    String getStyle();
} 