package com.designpatterns.creational.factory.abstractfactory;

/**
 * Concrete factory for creating Windows-style UI components.
 */
public class WindowsUIFactory implements UIFactory {
    
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
    
    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
    
    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

/**
 * Windows-style Button implementation.
 */
class WindowsButton implements Button {
    
    @Override
    public void render() {
        System.out.println("Rendering Windows-style button with 3D border");
    }
    
    @Override
    public void onClick() {
        System.out.println("Windows button clicked with system sound");
    }
    
    @Override
    public String getStyle() {
        return "Windows";
    }
}

/**
 * Windows-style TextField implementation.
 */
class WindowsTextField implements TextField {
    private String text = "";
    
    @Override
    public void render() {
        System.out.println("Rendering Windows-style text field with sunken border");
    }
    
    @Override
    public void setText(String text) {
        this.text = text;
        System.out.println("Windows text field updated: " + text);
    }
    
    @Override
    public String getText() {
        return text;
    }
    
    @Override
    public String getStyle() {
        return "Windows";
    }
}

/**
 * Windows-style Checkbox implementation.
 */
class WindowsCheckbox implements Checkbox {
    private boolean checked = false;
    
    @Override
    public void render() {
        System.out.println("Rendering Windows-style checkbox with square design");
    }
    
    @Override
    public void setChecked(boolean checked) {
        this.checked = checked;
        System.out.println("Windows checkbox " + (checked ? "checked" : "unchecked"));
    }
    
    @Override
    public boolean isChecked() {
        return checked;
    }
    
    @Override
    public String getStyle() {
        return "Windows";
    }
} 