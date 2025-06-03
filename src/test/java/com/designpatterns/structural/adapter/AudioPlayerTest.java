package com.designpatterns.structural.adapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for AudioPlayer class.
 */
class AudioPlayerTest {

    private AudioPlayer audioPlayer;

    @BeforeEach
    void setUp() {
        audioPlayer = new AudioPlayer();
    }

    @Test
    @DisplayName("Should play MP3 files natively")
    void testPlayMp3File() {
        assertDoesNotThrow(() -> {
            audioPlayer.play("mp3", "song.mp3");
        });
    }

    @Test
    @DisplayName("Should play MP4 files using adapter")
    void testPlayMp4File() {
        assertDoesNotThrow(() -> {
            audioPlayer.play("mp4", "movie.mp4");
        });
    }

    @Test
    @DisplayName("Should play VLC files using adapter")
    void testPlayVlcFile() {
        assertDoesNotThrow(() -> {
            audioPlayer.play("vlc", "documentary.vlc");
        });
    }

    @Test
    @DisplayName("Should handle case insensitive audio types")
    void testCaseInsensitivePlayback() {
        assertDoesNotThrow(() -> {
            audioPlayer.play("MP3", "song.mp3");
            audioPlayer.play("MP4", "movie.mp4");
            audioPlayer.play("VLC", "documentary.vlc");
        });
    }

    @Test
    @DisplayName("Should reject unsupported audio formats")
    void testUnsupportedAudioFormat() {
        // Should not throw exception, but should handle gracefully
        assertDoesNotThrow(() -> {
            audioPlayer.play("avi", "video.avi");
            audioPlayer.play("wav", "audio.wav");
        });
    }

    @Test
    @DisplayName("Should throw exception for null audio type")
    void testNullAudioType() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> audioPlayer.play(null, "test.mp3")
        );
        assertEquals("Audio type and file name cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception for null file name")
    void testNullFileName() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> audioPlayer.play("mp3", null)
        );
        assertEquals("Audio type and file name cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("Should correctly identify supported formats")
    void testIsFormatSupported() {
        assertTrue(audioPlayer.isFormatSupported("mp3"));
        assertTrue(audioPlayer.isFormatSupported("MP3"));
        assertTrue(audioPlayer.isFormatSupported("mp4"));
        assertTrue(audioPlayer.isFormatSupported("MP4"));
        assertTrue(audioPlayer.isFormatSupported("vlc"));
        assertTrue(audioPlayer.isFormatSupported("VLC"));
        
        assertFalse(audioPlayer.isFormatSupported("avi"));
        assertFalse(audioPlayer.isFormatSupported("wav"));
        assertFalse(audioPlayer.isFormatSupported("flac"));
        assertFalse(audioPlayer.isFormatSupported(null));
        assertFalse(audioPlayer.isFormatSupported(""));
    }

    @Test
    @DisplayName("Should handle empty string audio type")
    void testEmptyStringAudioType() {
        assertFalse(audioPlayer.isFormatSupported(""));
        
        // Should handle gracefully without throwing exception
        assertDoesNotThrow(() -> {
            audioPlayer.play("", "test.mp3");
        });
    }

    @Test
    @DisplayName("Should handle mixed case format checking")
    void testMixedCaseFormatSupport() {
        assertTrue(audioPlayer.isFormatSupported("Mp3"));
        assertTrue(audioPlayer.isFormatSupported("mP4"));
        assertTrue(audioPlayer.isFormatSupported("VlC"));
    }
} 