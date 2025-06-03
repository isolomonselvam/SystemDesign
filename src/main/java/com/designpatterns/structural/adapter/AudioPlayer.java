package com.designpatterns.structural.adapter;

/**
 * Client class that implements MediaPlayer interface.
 * This class can play MP3 files natively and uses MediaAdapter
 * to play other formats like MP4 and VLC.
 */
public class AudioPlayer implements MediaPlayer {
    
    private MediaAdapter mediaAdapter;
    
    @Override
    public void play(String audioType, String fileName) {
        if (audioType == null || fileName == null) {
            throw new IllegalArgumentException("Audio type and file name cannot be null");
        }
        
        System.out.println("\n🎧 AudioPlayer: Attempting to play " + audioType.toUpperCase() + " file: " + fileName);
        
        // Built-in support for MP3 files
        if (audioType.equalsIgnoreCase("mp3")) {
            playMp3(fileName);
        }
        // Use adapter for other formats
        else if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")) {
            try {
                mediaAdapter = new MediaAdapter(audioType);
                System.out.println("📡 Using adapter: " + mediaAdapter.getPlayerType());
                mediaAdapter.play(audioType, fileName);
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }
        // Unsupported format
        else {
            System.out.println("❌ " + audioType + " format not supported. Supported formats: MP3, MP4, VLC");
        }
    }
    
    /**
     * Native method to play MP3 files.
     * 
     * @param fileName the name of the MP3 file to play
     */
    private void playMp3(String fileName) {
        System.out.println("🎶 Playing MP3 file natively: " + fileName);
        // Simulate MP3 playback
        try {
            Thread.sleep(300);
            System.out.println("✅ MP3 playback completed successfully");
        } catch (InterruptedException e) {
            System.out.println("❌ MP3 playback interrupted");
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Check if a given audio type is supported.
     * 
     * @param audioType the audio type to check
     * @return true if supported, false otherwise
     */
    public boolean isFormatSupported(String audioType) {
        if (audioType == null) {
            return false;
        }
        
        String type = audioType.toLowerCase();
        return type.equals("mp3") || type.equals("mp4") || type.equals("vlc");
    }
} 