# Adapter Pattern Implementation

## 📋 Overview

The Adapter pattern allows incompatible interfaces to work together by creating a bridge between them. It acts as a wrapper that converts the interface of one class into another interface that clients expect.

## 🎯 Problem Solved

Imagine you have an existing `AudioPlayer` class that can only play MP3 files, but you want to extend it to play MP4 and VLC files using existing specialized player classes (`Mp4Player` and `VlcPlayer`) that have different interfaces. The Adapter pattern solves this without modifying existing code.

## 🏗️ Structure

```
MediaPlayer (Target Interface)
    ↑
AudioPlayer (Client) ←→ MediaAdapter (Adapter) ←→ AdvancedMediaPlayer (Adaptee Interface)
                                                        ↑                    ↑
                                                   Mp4Player            VlcPlayer
```

## 📁 Components

### 1. **Target Interface** (`MediaPlayer`)
- Defines the interface that the client expects
- `play(String audioType, String fileName)`

### 2. **Adaptee Interface** (`AdvancedMediaPlayer`)
- Represents the incompatible interface we want to adapt
- `playMp4(String fileName)` and `playVlc(String fileName)`

### 3. **Concrete Adaptees** (`Mp4Player`, `VlcPlayer`)
- Existing classes with specific functionality
- Each handles a specific audio format

### 4. **Adapter** (`MediaAdapter`)
- Implements the target interface (`MediaPlayer`)
- Wraps the adaptee and translates calls
- Bridges the gap between incompatible interfaces

### 5. **Client** (`AudioPlayer`)
- Uses the target interface
- Can play MP3 natively and other formats through adapter

## 🎮 Usage Example

```java
AudioPlayer audioPlayer = new AudioPlayer();

// Native MP3 support
audioPlayer.play("mp3", "song.mp3");

// Using adapter for MP4
audioPlayer.play("mp4", "movie.mp4");

// Using adapter for VLC
audioPlayer.play("vlc", "documentary.vlc");
```

## ✨ Key Benefits

1. **Interface Compatibility**: Makes incompatible interfaces work together
2. **Code Reusability**: Reuses existing classes without modification
3. **Separation of Concerns**: Each player handles its specific format
4. **Extensibility**: Easy to add new formats by creating new adapters
5. **Single Responsibility**: Adapter only handles interface translation

## 🔄 How It Works

1. **Client Request**: `AudioPlayer.play("mp4", "movie.mp4")`
2. **Adapter Creation**: Creates `MediaAdapter` for MP4 format
3. **Adaptee Selection**: Adapter creates `Mp4Player` instance
4. **Interface Translation**: Adapter calls `mp4Player.playMp4(fileName)`
5. **Result**: MP4 file plays through the adapted interface

## 🧪 Testing

The implementation includes comprehensive testing for:
- ✅ Native format support (MP3)
- ✅ Adapted format support (MP4, VLC)
- ✅ Unsupported format handling
- ✅ Error handling (null parameters)
- ✅ Format support validation

## 🎯 Real-World Applications

- **Legacy System Integration**: Connecting old and new systems
- **Third-Party Library Integration**: Using libraries with different interfaces
- **Database Adapters**: Connecting to different database types
- **Payment Gateway Integration**: Supporting multiple payment providers
- **File Format Converters**: Handling different file formats

## 🚀 Running the Demo

```bash
# Using Maven
mvn exec:java -Dexec.mainClass="com.designpatterns.structural.adapter.AdapterDemo"

# Using the demo runner script
./run-demo.sh adapter
```

## 📊 Pattern Comparison

| Pattern | Purpose | When to Use |
|---------|---------|-------------|
| **Adapter** | Interface compatibility | Existing classes with incompatible interfaces |
| **Decorator** | Add behavior | Extend functionality dynamically |
| **Facade** | Simplify interface | Complex subsystem with simple interface |
| **Proxy** | Control access | Add security, caching, or lazy loading |

## 🎨 Implementation Highlights

- **Type Safety**: Enum-based format validation
- **Error Handling**: Comprehensive null checks and validation
- **Performance**: Minimal overhead in adaptation
- **Maintainability**: Clear separation of responsibilities
- **Extensibility**: Easy to add new audio formats

This implementation demonstrates the Adapter pattern's power in creating seamless integration between incompatible interfaces while maintaining clean, maintainable code. 