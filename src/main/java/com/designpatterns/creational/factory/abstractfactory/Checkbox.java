package com.designpatterns.creational.factory.abstractfactory;

/**
 * Abstract product interface for Checkbox components.
 */
public interface Checkbox {
    void render();
    void setChecked(boolean checked);
    boolean isChecked();
    String getStyle();
} 