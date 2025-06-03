package com.designpatterns.structural.adapter;

/**
 * Adaptee interface representing advanced media players with a generic play method.
 * This interface follows the Open/Closed Principle - new player types can be added
 * without changing this interface or existing implementations.
 */
public interface AdvancedMediaPlayer {
    
    /**
     * Play media file. Each implementation handles its specific format internally.
     * 
     * @param fileName the name of the file to play
     */
    void play(String fileName);
    
    /**
     * Get the supported media format for this player.
     * 
     * @return the media format this player supports (e.g., "mp4", "vlc")
     */
    String getSupportedFormat();
} 