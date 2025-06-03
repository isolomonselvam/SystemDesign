package com.designpatterns.creational.factory.abstractfactory;

/**
 * Concrete factory for creating Mac-style UI components.
 */
public class MacUIFactory implements UIFactory {
    
    @Override
    public Button createButton() {
        return new MacButton();
    }
    
    @Override
    public TextField createTextField() {
        return new MacTextField();
    }
    
    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

/**
 * Mac-style Button implementation.
 */
class MacButton implements Button {
    
    @Override
    public void render() {
        System.out.println("Rendering Mac-style button with rounded corners and gradient");
    }
    
    @Override
    public void onClick() {
        System.out.println("Mac button clicked with subtle animation");
    }
    
    @Override
    public String getStyle() {
        return "Mac";
    }
}

/**
 * Mac-style TextField implementation.
 */
class MacTextField implements TextField {
    private String text = "";
    
    @Override
    public void render() {
        System.out.println("Rendering Mac-style text field with rounded border and focus ring");
    }
    
    @Override
    public void setText(String text) {
        this.text = text;
        System.out.println("Mac text field updated with smooth transition: " + text);
    }
    
    @Override
    public String getText() {
        return text;
    }
    
    @Override
    public String getStyle() {
        return "Mac";
    }
}

/**
 * Mac-style Checkbox implementation.
 */
class MacCheckbox implements Checkbox {
    private boolean checked = false;
    
    @Override
    public void render() {
        System.out.println("Rendering Mac-style checkbox with rounded design and blue accent");
    }
    
    @Override
    public void setChecked(boolean checked) {
        this.checked = checked;
        System.out.println("Mac checkbox " + (checked ? "checked with checkmark animation" : "unchecked"));
    }
    
    @Override
    public boolean isChecked() {
        return checked;
    }
    
    @Override
    public String getStyle() {
        return "Mac";
    }
} 