package com.designpatterns.structural.adapter;

/**
 * Demo class to demonstrate the Adapter pattern.
 * Shows how incompatible interfaces can work together through an adapter.
 */
public class AdapterDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Adapter Pattern Demo ===");
        System.out.println("Demonstrating how incompatible interfaces work together\n");
        
        AudioPlayer audioPlayer = new AudioPlayer();
        
        // Test native MP3 support
        audioPlayer.play("mp3", "beyond_the_horizon.mp3");
        
        // Test adapted formats
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far_far_away.vlc");
        
        // Test unsupported format
        audioPlayer.play("avi", "mind_me.avi");
        
        System.out.println("\n=== Pattern Explanation ===");
        System.out.println("✅ AudioPlayer natively supports MP3");
        System.out.println("✅ MediaAdapter allows MP4 and VLC support");
        System.out.println("✅ Incompatible interfaces work together seamlessly");
        System.out.println("✅ Client code remains simple and clean");
        
        System.out.println("\n=== SOLID Principle Fix ===");
        System.out.println("✅ AdvancedMediaPlayer now uses generic play() method");
        System.out.println("✅ New formats can be added without modifying the interface");
        System.out.println("✅ Open/Closed Principle: Open for extension, closed for modification");
    }
} 