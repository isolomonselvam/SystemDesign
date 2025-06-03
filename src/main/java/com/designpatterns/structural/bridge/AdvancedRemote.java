package com.designpatterns.structural.bridge;

/**
 * Refined abstraction - Advanced remote control with sophisticated functionality.
 * This class extends the RemoteControl abstraction and adds advanced features
 * while still working with any Device implementation.
 */
public class AdvancedRemote extends RemoteControl {
    
    private boolean isMuted = false;
    private int volumeBeforeMute = 0;
    
    /**
     * Constructor that accepts a device implementation.
     * 
     * @param device the device to control
     */
    public AdvancedRemote(Device device) {
        super(device);
    }
    
    /**
     * Mute/unmute functionality - advanced feature.
     */
    public void mute() {
        if (!isMuted) {
            volumeBeforeMute = device.getVolume();
            device.setVolume(0);
            isMuted = true;
            System.out.println("🔇 Device muted");
        } else {
            device.setVolume(volumeBeforeMute);
            isMuted = false;
            System.out.println("🔊 Device unmuted");
        }
    }
    
    /**
     * Set volume with percentage display - advanced feature.
     * 
     * @param volume volume level (0-100)
     */
    public void setVolumeWithPercentage(int volume) {
        device.setVolume(volume);
        System.out.println("🎚️ Volume: " + volume + "%");
    }
    
    /**
     * Advanced status display with more details.
     */
    public void displayAdvancedStatus() {
        System.out.println("\n=== Advanced Remote Status ===");
        System.out.println("Device Type: " + device.getClass().getSimpleName());
        System.out.println("Power State: " + (device.isEnabled() ? "🟢 ON" : "🔴 OFF"));
        System.out.println("Volume Level: " + device.getVolume() + "/100");
        System.out.println("Mute Status: " + (isMuted ? "🔇 MUTED" : "🔊 ACTIVE"));
        
        // Show device-specific info if available
        if (device instanceof TV) {
            TV tv = (TV) device;
            System.out.println("Current Channel: " + tv.getChannel());
        } else if (device instanceof Radio) {
            Radio radio = (Radio) device;
            System.out.println("Current Frequency: " + radio.getFrequency() + " FM");
        }
        System.out.println("===============================");
    }
    
    /**
     * Quick setup - turn on device and set optimal volume.
     */
    public void quickSetup() {
        System.out.println("🚀 Quick Setup initiated...");
        if (!device.isEnabled()) {
            device.powerOn();
        }
        device.setVolume(50); // Set to comfortable level
        isMuted = false;
        System.out.println("✅ Quick Setup complete!");
    }
} 