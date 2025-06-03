package com.designpatterns.creational.factory.abstractfactory;

/**
 * Demo class to demonstrate the Abstract Factory pattern.
 * Shows how to create families of related UI components.
 */
public class AbstractFactoryDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Abstract Factory Pattern Demo ===\n");
        
        // Simulate different operating systems
        String os = System.getProperty("os.name").toLowerCase();
        
        System.out.println("🖥️ Detected OS: " + System.getProperty("os.name"));
        System.out.println("Creating appropriate UI components...\n");
        
        // Create factory based on OS
        UIFactory factory = createUIFactory(os);
        
        // Create UI components using the factory
        createAndDemonstrateUI(factory);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Demonstrate switching between different UI styles
        System.out.println("🔄 Demonstrating UI style switching:\n");
        
        System.out.println("--- Windows UI ---");
        createAndDemonstrateUI(new WindowsUIFactory());
        
        System.out.println("\n--- Mac UI ---");
        createAndDemonstrateUI(new MacUIFactory());
        
        System.out.println("\n=== Abstract Factory Pattern Demo Complete ===");
    }
    
    /**
     * Factory method to create appropriate UI factory based on OS.
     */
    private static UIFactory createUIFactory(String os) {
        if (os.contains("mac") || os.contains("darwin")) {
            System.out.println("🍎 Creating Mac UI Factory");
            return new MacUIFactory();
        } else {
            System.out.println("🪟 Creating Windows UI Factory");
            return new WindowsUIFactory();
        }
    }
    
    /**
     * Creates and demonstrates UI components using the given factory.
     */
    private static void createAndDemonstrateUI(UIFactory factory) {
        // Create components
        Button button = factory.createButton();
        TextField textField = factory.createTextField();
        Checkbox checkbox = factory.createCheckbox();
        
        System.out.println("📱 Creating UI components with " + button.getStyle() + " style:");
        
        // Render components
        button.render();
        textField.render();
        checkbox.render();
        
        System.out.println("\n🎯 Interacting with components:");
        
        // Interact with components
        button.onClick();
        textField.setText("Hello, " + button.getStyle() + "!");
        checkbox.setChecked(true);
        
        System.out.println("📝 Text field content: " + textField.getText());
        System.out.println("☑️ Checkbox state: " + (checkbox.isChecked() ? "checked" : "unchecked"));
    }
} 