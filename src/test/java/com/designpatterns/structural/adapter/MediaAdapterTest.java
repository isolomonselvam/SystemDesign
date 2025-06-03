package com.designpatterns.structural.adapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for MediaAdapter class.
 */
class MediaAdapterTest {

    @Test
    @DisplayName("Should create MP4 adapter successfully")
    void testCreateMp4Adapter() {
        MediaAdapter adapter = new MediaAdapter("mp4");
        assertEquals("Mp4Player", adapter.getPlayerType());
    }

    @Test
    @DisplayName("Should create VLC adapter successfully")
    void testCreateVlcAdapter() {
        MediaAdapter adapter = new MediaAdapter("vlc");
        assertEquals("VlcPlayer", adapter.getPlayerType());
    }

    @Test
    @DisplayName("Should handle case insensitive audio types")
    void testCaseInsensitiveAudioTypes() {
        MediaAdapter mp4Adapter = new MediaAdapter("MP4");
        MediaAdapter vlcAdapter = new MediaAdapter("VLC");
        
        assertEquals("Mp4Player", mp4Adapter.getPlayerType());
        assertEquals("VlcPlayer", vlcAdapter.getPlayerType());
    }

    @Test
    @DisplayName("Should throw exception for null audio type")
    void testNullAudioType() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new MediaAdapter(null)
        );
        assertEquals("Audio type cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception for unsupported audio type")
    void testUnsupportedAudioType() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new MediaAdapter("avi")
        );
        assertEquals("Unsupported audio type: avi", exception.getMessage());
    }

    @Test
    @DisplayName("Should play MP4 file successfully")
    void testPlayMp4File() {
        MediaAdapter adapter = new MediaAdapter("mp4");
        
        assertDoesNotThrow(() -> {
            adapter.play("mp4", "test.mp4");
        });
    }

    @Test
    @DisplayName("Should play VLC file successfully")
    void testPlayVlcFile() {
        MediaAdapter adapter = new MediaAdapter("vlc");
        
        assertDoesNotThrow(() -> {
            adapter.play("vlc", "test.vlc");
        });
    }

    @Test
    @DisplayName("Should throw exception for null parameters in play method")
    void testPlayWithNullParameters() {
        MediaAdapter adapter = new MediaAdapter("mp4");
        
        IllegalArgumentException exception1 = assertThrows(
            IllegalArgumentException.class,
            () -> adapter.play(null, "test.mp4")
        );
        assertEquals("Audio type and file name cannot be null", exception1.getMessage());
        
        IllegalArgumentException exception2 = assertThrows(
            IllegalArgumentException.class,
            () -> adapter.play("mp4", null)
        );
        assertEquals("Audio type and file name cannot be null", exception2.getMessage());
    }

    @Test
    @DisplayName("Should handle different audio types in play method")
    void testPlayDifferentAudioTypes() {
        MediaAdapter mp4Adapter = new MediaAdapter("mp4");
        MediaAdapter vlcAdapter = new MediaAdapter("vlc");
        
        // Both should work without throwing exceptions
        assertDoesNotThrow(() -> {
            mp4Adapter.play("mp4", "test.mp4");
            vlcAdapter.play("vlc", "test.vlc");
        });
    }
} 