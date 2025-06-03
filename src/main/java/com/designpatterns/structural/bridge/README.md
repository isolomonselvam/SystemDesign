# Bridge Pattern Implementation

## Overview
The Bridge pattern separates an abstraction from its implementation so that both can vary independently.

## Key Difference from Adapter Pattern
- **Adapter**: Makes incompatible interfaces work together (reactive)
- **Bridge**: Separates abstraction from implementation (proactive design)

## Structure
```
RemoteControl (Abstraction)
    ↓ uses
Device (Implementation Interface)
    ↓ implemented by
Concrete Devices (TV, Radio, etc.)
```

## Components ✅ COMPLETE

### Abstraction Hierarchy
- `RemoteControl` - Base abstraction ✅
- `BasicRemote` - Simple remote with basic features ✅
- `AdvancedRemote` - Smart remote with advanced features ✅

### Implementation Hierarchy  
- `Device` - Implementation interface ✅
- `TV` - Television with channel control ✅
- `Radio` - Radio with frequency tuning ✅

## Key Benefits Demonstrated
- ✅ Abstraction and implementation evolve independently
- ✅ Runtime binding of implementation
- ✅ Same remote can control different devices
- ✅ Different remotes can control same device
- ✅ Easy to add new remote types or device types
- ✅ Device-specific features preserved

## Usage Examples

### Basic Usage
```java
// Create devices
Device tv = new TV();
Device radio = new Radio();

// Create remotes with different devices
BasicRemote basicTvRemote = new BasicRemote(tv);
AdvancedRemote advancedRadioRemote = new AdvancedRemote(radio);

// Use them
basicTvRemote.turnOn();
basicTvRemote.setVolume(60);

advancedRadioRemote.quickSetup();
advancedRadioRemote.mute();
```

### Advanced Features
```java
// Advanced remote with TV
AdvancedRemote smartRemote = new AdvancedRemote(tv);
smartRemote.quickSetup();
smartRemote.setVolumeWithPercentage(75);
smartRemote.displayAdvancedStatus();

// Device-specific features
TV tvDevice = (TV) tv;
tvDevice.setChannel(5);

Radio radioDevice = (Radio) radio;
radioDevice.setFrequency(95.5);
```

## Running the Demo
```bash
java -cp target/classes com.designpatterns.structural.bridge.BridgeDemo
```

## Pattern Comparison
| Aspect | Bridge | Adapter |
|--------|--------|---------|
| Purpose | Separate abstraction from implementation | Make incompatible interfaces work |
| When | Design time (proactive) | Runtime (reactive) |
| Structure | Two hierarchies connected | Wrapper around existing class |
| Flexibility | High - both sides can vary | Limited - fixes specific incompatibility | 