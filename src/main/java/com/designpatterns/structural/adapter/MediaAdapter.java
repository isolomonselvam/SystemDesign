package com.designpatterns.structural.adapter;

/**
 * Adapter class that implements the MediaPlayer interface and adapts
 * AdvancedMediaPlayer implementations to work with the MediaPlayer interface.
 * This version uses a simple approach that follows the Open/Closed Principle.
 */
public class MediaAdapter implements MediaPlayer {
    
    private AdvancedMediaPlayer advancedMusicPlayer;
    
    /**
     * Constructor that creates the appropriate AdvancedMediaPlayer based on audio type.
     * 
     * @param audioType the type of audio file to be played
     */
    public MediaAdapter(String audioType) {
        if (audioType == null) {
            throw new IllegalArgumentException("Audio type cannot be null");
        }
        
        switch (audioType.toLowerCase()) {
            case "mp4":
                advancedMusicPlayer = new Mp4Player();
                break;
            case "vlc":
                advancedMusicPlayer = new VlcPlayer();
                break;
            default:
                throw new IllegalArgumentException("Unsupported audio type: " + audioType);
        }
    }
    
    @Override
    public void play(String audioType, String fileName) {
        if (audioType == null || fileName == null) {
            throw new IllegalArgumentException("Audio type and file name cannot be null");
        }
        
        System.out.println("🔄 MediaAdapter: Adapting " + audioType.toUpperCase() + " playback...");
        advancedMusicPlayer.play(fileName);
    }
    
    /**
     * Get the type of advanced media player being used.
     * 
     * @return the class name of the advanced media player
     */
    public String getPlayerType() {
        return advancedMusicPlayer.getClass().getSimpleName();
    }
} 