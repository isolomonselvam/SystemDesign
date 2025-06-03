package com.designpatterns.structural.bridge;

/**
 * Implementation interface that defines the bridge.
 * This interface will be implemented by concrete devices.
 * The abstraction (RemoteControl) will use this interface.
 */
public interface Device {
    
    /**
     * Turn the device on.
     */
    void powerOn();
    
    /**
     * Turn the device off.
     */
    void powerOff();
    
    /**
     * Check if device is currently enabled/on.
     * 
     * @return true if device is on, false otherwise
     */
    boolean isEnabled();
    
    /**
     * Get current volume level.
     * 
     * @return volume level (0-100)
     */
    int getVolume();
    
    /**
     * Set volume level.
     * 
     * @param volume volume level (0-100)
     */
    void setVolume(int volume);
} 