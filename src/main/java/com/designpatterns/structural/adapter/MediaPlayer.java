package com.designpatterns.structural.adapter;

/**
 * Target interface that defines the expected interface for media playback.
 * This is what our client code expects to work with.
 */
public interface MediaPlayer {
    
    /**
     * Play audio file of the specified type.
     * 
     * @param audioType the type of audio file (mp3, mp4, vlc, etc.)
     * @param fileName the name of the file to play
     */
    void play(String audioType, String fileName);
} 