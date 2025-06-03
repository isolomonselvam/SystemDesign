package com.designpatterns.structural.bridge;

/**
 * Concrete implementation of Device interface for Radio.
 * This class can evolve independently from the RemoteControl abstraction.
 */
public class Radio implements Device {
    
    private boolean isOn = false;
    private int volume = 50;
    private double frequency = 101.5; // FM frequency
    
    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("📻 Radio is now ON");
    }
    
    @Override
    public void powerOff() {
        isOn = false;
        System.out.println("📻 Radio is now OFF");
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
        System.out.println("📻 Radio volume set to: " + volume);
    }
    
    /**
     * Radio-specific method - tune to frequency.
     * This shows how implementations can have their own unique features.
     * 
     * @param frequency FM frequency (88.0 - 108.0)
     */
    public void setFrequency(double frequency) {
        if (isOn && frequency >= 88.0 && frequency <= 108.0) {
            this.frequency = frequency;
            System.out.println("📻 Radio tuned to: " + frequency + " FM");
        } else if (!isOn) {
            System.out.println("📻 Radio is off - cannot change frequency");
        } else {
            System.out.println("📻 Invalid frequency. Use 88.0 - 108.0 FM");
        }
    }
    
    public double getFrequency() {
        return frequency;
    }
} 