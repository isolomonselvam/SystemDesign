package com.designpatterns.structural.adapter;

/**
 * Concrete implementation of AdvancedMediaPlayer for VLC files.
 * This class follows the Open/Closed Principle - new formats can be added
 * without modifying this class or the interface.
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    
    @Override
    public void play(String fileName) {
        System.out.println("🎬 Playing VLC file: " + fileName);
        // Simulate VLC playback with some processing time
        try {
            Thread.sleep(700);
            System.out.println("✅ VLC playback completed successfully");
        } catch (InterruptedException e) {
            System.out.println("❌ VLC playback interrupted");
            Thread.currentThread().interrupt();
        }
    }
    
    @Override
    public String getSupportedFormat() {
        return "vlc";
    }
    
    /**
     * Legacy method for backward compatibility.
     * @deprecated Use {@link #play(String)} instead
     */
    @Deprecated
    public void playVlc(String fileName) {
        play(fileName);
    }
} 