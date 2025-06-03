package com.designpatterns.structural.bridge;

/**
 * Abstraction class that defines the interface for remote controls.
 * This class holds a reference to the Device implementation interface,
 * creating a bridge between the abstraction and implementation hierarchies.
 */
public abstract class RemoteControl {
    
    protected Device device;
    
    /**
     * Constructor that accepts a device implementation.
     * This creates the bridge between abstraction and implementation.
     * 
     * @param device the device to control
     */
    public RemoteControl(Device device) {
        this.device = device;
    }
    
    /**
     * Turn the device on.
     */
    public void turnOn() {
        device.powerOn();
    }
    
    /**
     * Turn the device off.
     */
    public void turnOff() {
        device.powerOff();
    }
    
    /**
     * Toggle device power state.
     */
    public void togglePower() {
        if (device.isEnabled()) {
            device.powerOff();
        } else {
            device.powerOn();
        }
    }
    
    /**
     * Set volume level.
     * 
     * @param volume volume level (0-100)
     */
    public void setVolume(int volume) {
        device.setVolume(volume);
    }
    
    /**
     * Get current volume.
     * 
     * @return current volume level
     */
    public int getVolume() {
        return device.getVolume();
    }
} 