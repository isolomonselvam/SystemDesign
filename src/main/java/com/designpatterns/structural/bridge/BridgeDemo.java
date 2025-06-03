package com.designpatterns.structural.bridge;

/**
 * Demo class to demonstrate the Bridge pattern.
 * Shows how abstraction and implementation can vary independently.
 */
public class BridgeDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Bridge Pattern Demo ===");
        System.out.println("Demonstrating separation of abstraction from implementation\n");
        
        // Create devices (implementations)
        Device tv = new TV();
        Device radio = new Radio();
        
        System.out.println("🎯 Bridge Pattern Key Concept:");
        System.out.println("Same remote types can control different devices!");
        System.out.println("Same devices can be controlled by different remotes!\n");
        
        // Demo 1: Basic Remote with TV
        System.out.println("📱 Demo 1: Basic Remote controlling TV");
        System.out.println("=====================================");
        BasicRemote basicTvRemote = new BasicRemote(tv);
        basicTvRemote.turnOn();
        basicTvRemote.setVolume(60);
        basicTvRemote.volumeUp();
        basicTvRemote.displayStatus();
        
        // Demo 2: Basic Remote with Radio  
        System.out.println("\n📻 Demo 2: Basic Remote controlling Radio");
        System.out.println("==========================================");
        BasicRemote basicRadioRemote = new BasicRemote(radio);
        basicRadioRemote.turnOn();
        basicRadioRemote.setVolume(40);
        basicRadioRemote.volumeDown();
        basicRadioRemote.displayStatus();
        
        // Demo 3: Advanced Remote with TV
        System.out.println("\n🎮 Demo 3: Advanced Remote controlling TV");
        System.out.println("==========================================");
        AdvancedRemote advancedTvRemote = new AdvancedRemote(tv);
        advancedTvRemote.quickSetup();
        advancedTvRemote.setVolumeWithPercentage(75);
        advancedTvRemote.mute();
        advancedTvRemote.mute(); // Unmute
        advancedTvRemote.displayAdvancedStatus();
        
        // Demo 4: Advanced Remote with Radio
        System.out.println("\n📡 Demo 4: Advanced Remote controlling Radio");
        System.out.println("=============================================");
        AdvancedRemote advancedRadioRemote = new AdvancedRemote(radio);
        advancedRadioRemote.quickSetup();
        advancedRadioRemote.setVolumeWithPercentage(80);
        advancedRadioRemote.displayAdvancedStatus();
        
        // Demo 5: Runtime device switching
        System.out.println("\n🔄 Demo 5: Runtime Device Switching");
        System.out.println("====================================");
        System.out.println("Creating new advanced remote and switching devices...");
        
        AdvancedRemote universalRemote = new AdvancedRemote(tv);
        System.out.println("\n🎬 Controlling TV:");
        universalRemote.turnOn();
        universalRemote.setVolume(30);
        
        // Switch to radio (this would require a setter method in real implementation)
        System.out.println("\n📻 Now controlling Radio:");
        AdvancedRemote radioRemote = new AdvancedRemote(radio);
        radioRemote.turnOn();
        radioRemote.setVolume(70);
        
        // Demo 6: Device-specific features
        System.out.println("\n🎯 Demo 6: Device-Specific Features");
        System.out.println("====================================");
        
        // TV specific features
        if (tv instanceof TV) {
            TV tvDevice = (TV) tv;
            tvDevice.setChannel(5);
            tvDevice.setChannel(12);
        }
        
        // Radio specific features  
        if (radio instanceof Radio) {
            Radio radioDevice = (Radio) radio;
            radioDevice.setFrequency(95.5);
            radioDevice.setFrequency(102.1);
        }
        
        // Final status
        System.out.println("\n📊 Final Status Check");
        System.out.println("=====================");
        AdvancedRemote finalTvRemote = new AdvancedRemote(tv);
        AdvancedRemote finalRadioRemote = new AdvancedRemote(radio);
        
        finalTvRemote.displayAdvancedStatus();
        finalRadioRemote.displayAdvancedStatus();
        
        System.out.println("\n🎉 Bridge Pattern Benefits Demonstrated:");
        System.out.println("✅ Abstraction (Remote) and Implementation (Device) vary independently");
        System.out.println("✅ Same remote can control different devices");
        System.out.println("✅ Different remotes can control same device");
        System.out.println("✅ Easy to add new remote types or device types");
        System.out.println("✅ Runtime binding of implementation");
    }
} 