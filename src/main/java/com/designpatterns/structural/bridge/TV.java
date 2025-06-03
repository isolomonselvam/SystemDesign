package com.designpatterns.structural.bridge;

/**
 * Concrete implementation of Device interface for TV.
 * This class can evolve independently from the RemoteControl abstraction.
 */
public class TV implements Device {
    
    private boolean isOn = false;
    private int volume = 30;
    private int channel = 1;
    
    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("📺 TV is now ON");
    }
    
    @Override
    public void powerOff() {
        isOn = false;
        System.out.println("📺 TV is now OFF");
    }
    
    @Override
    public boolean isEnabled() {
        return isOn;
    }
    
    @Override
    public int getVolume() {
        return volume;
    }
    
    @Override
    public void setVolume(int volume) {
        if (volume < 0) volume = 0;
        if (volume > 100) volume = 100;
        
        this.volume = volume;
        System.out.println("📺 TV volume set to: " + volume);
    }
    
    /**
     * TV-specific method - change channel.
     * This shows how implementations can have their own unique features.
     * 
     * @param channel channel number
     */
    public void setChannel(int channel) {
        if (isOn && channel > 0) {
            this.channel = channel;
            System.out.println("📺 TV channel changed to: " + channel);
        } else if (!isOn) {
            System.out.println("📺 TV is off - cannot change channel");
        }
    }
    
    public int getChannel() {
        return channel;
    }
} 