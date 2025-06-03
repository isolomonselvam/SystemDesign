package com.designpatterns.structural.adapter;

/**
 * Concrete implementation of AdvancedMediaPlayer for MP4 files.
 * This class follows the Open/Closed Principle - new formats can be added
 * without modifying this class or the interface.
 */
public class Mp4Player implements AdvancedMediaPlayer {
    
    @Override
    public void play(String fileName) {
        System.out.println("🎵 Playing MP4 file: " + fileName);
        // Simulate MP4 playback with some processing time
        try {
            Thread.sleep(500);
            System.out.println("✅ MP4 playback completed successfully");
        } catch (InterruptedException e) {
            System.out.println("❌ MP4 playback interrupted");
            Thread.currentThread().interrupt();
        }
    }
    
    @Override
    public String getSupportedFormat() {
        return "mp4";
    }
    
    /**
     * Legacy method for backward compatibility.
     * @deprecated Use {@link #play(String)} instead
     */
    @Deprecated
    public void playMp4(String fileName) {
        play(fileName);
    }
} 