package com.designpatterns.structural.bridge;

/**
 * Refined abstraction - Basic remote control with simple functionality.
 * This class extends the RemoteControl abstraction and can work with any Device implementation.
 */
public class BasicRemote extends RemoteControl {
    
    /**
     * Constructor that accepts a device implementation.
     * 
     * @param device the device to control
     */
    public BasicRemote(Device device) {
        super(device);
    }
    
    /**
     * Display current device status.
     * This is a basic remote specific feature.
     */
    public void displayStatus() {
        System.out.println("\n--- Basic Remote Status ---");
        System.out.println("Device: " + device.getClass().getSimpleName());
        System.out.println("Power: " + (device.isEnabled() ? "ON" : "OFF"));
        System.out.println("Volume: " + device.getVolume());
        System.out.println("---------------------------");
    }
    
    /**
     * Simple volume up by 10.
     */
    public void volumeUp() {
        int currentVolume = device.getVolume();
        device.setVolume(currentVolume + 10);
    }
    
    /**
     * Simple volume down by 10.
     */
    public void volumeDown() {
        int currentVolume = device.getVolume();
        device.setVolume(currentVolume - 10);
    }
} 