# System Design Patterns in Java

A comprehensive Java project demonstrating various system design patterns commonly used in software engineering and system architecture.

## 📋 Table of Contents

- [Overview](#overview)
- [Project Structure](#project-structure)
- [Design Patterns Included](#design-patterns-included)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Running Demos](#running-demos)
- [Running Tests](#running-tests)
- [Contributing](#contributing)

## 🎯 Overview

This project serves as a practical reference for implementing various design patterns in Java. Each pattern is implemented with:
- Clear, well-documented code
- Real-world examples
- Unit tests
- Usage demonstrations

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── designpatterns/
│   │           ├── creational/          # Creational patterns
│   │           │   ├── singleton/       ✅ Implemented
│   │           │   ├── factory/         ✅ Implemented
│   │           │   ├── builder/
│   │           │   └── prototype/
│   │           ├── structural/          # Structural patterns
│   │           │   ├── adapter/         ✅ Implemented
│   │           │   ├── decorator/       ✅ Implemented
│   │           │   ├── facade/
│   │           │   └── proxy/
│   │           ├── behavioral/          # Behavioral patterns
│   │           │   ├── observer/        ✅ Implemented
│   │           │   ├── strategy/        ✅ Implemented
│   │           │   ├── command/
│   │           │   └── state/
│   │           └── system/              # System design patterns
│   │               ├── loadbalancer/
│   │               ├── circuitbreaker/
│   │               ├── ratelimiter/
│   │               └── cache/
│   └── resources/
└── test/
    ├── java/
    │   └── com/
    │       └── designpatterns/
    └── resources/
```

## 🎨 Design Patterns Included

### Creational Patterns
- **✅ Singleton**: Ensures a class has only one instance with thread-safe implementation
- **✅ Factory Method**: Creates objects without specifying exact classes (Shape factory example)
- **Builder**: Constructs complex objects step by step
- **Prototype**: Creates objects by cloning existing instances

### Structural Patterns
- **✅ Adapter**: Allows incompatible interfaces to work together (Media player example)
- **✅ Decorator**: Adds behavior to objects dynamically (Coffee shop example)
- **Facade**: Provides a simplified interface to complex subsystems
- **Proxy**: Provides a placeholder/surrogate for another object

### Behavioral Patterns
- **✅ Observer**: Defines a one-to-many dependency between objects (News subscription example)
- **✅ Strategy**: Defines a family of algorithms and makes them interchangeable (Payment processing example)
- **Command**: Encapsulates a request as an object
- **State**: Allows an object to alter its behavior when its internal state changes

### System Design Patterns
- **Load Balancer**: Distributes incoming requests across multiple servers
- **Circuit Breaker**: Prevents cascading failures in distributed systems
- **Rate Limiter**: Controls the rate of requests to prevent system overload
- **Cache**: Stores frequently accessed data for quick retrieval

## 🔧 Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- IDE of your choice (IntelliJ IDEA, Eclipse, VS Code)

## 🚀 Getting Started

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Design
   ```

2. **Build the project**
   ```bash
   mvn clean compile
   ```

3. **Run a specific pattern example**
   ```bash
   mvn exec:java -Dexec.mainClass="com.designpatterns.creational.singleton.SingletonDemo"
   ```

## 🎭 Running Demos

Use the convenient demo runner script to explore different patterns:

```bash
# Show available demos
./run-demo.sh

# Run specific pattern demos
./run-demo.sh singleton   # Singleton Pattern Demo
./run-demo.sh factory     # Factory Pattern Demo  
./run-demo.sh strategy    # Strategy Pattern Demo
./run-demo.sh observer    # Observer Pattern Demo
./run-demo.sh decorator   # Decorator Pattern Demo
./run-demo.sh adapter     # Adapter Pattern Demo
```

Or run demos directly with Maven:
```bash
# Singleton Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.creational.singleton.SingletonDemo"

# Factory Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.creational.factory.FactoryDemo"

# Strategy Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.behavioral.strategy.StrategyDemo"

# Observer Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.behavioral.observer.ObserverDemo"

# Decorator Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.structural.decorator.DecoratorDemo"

# Adapter Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.structural.adapter.AdapterDemo"
```

## 🧪 Running Tests

Run all tests:
```bash
mvn test
```

Run tests for a specific pattern:
```bash
mvn test -Dtest="*Singleton*"
mvn test -Dtest="*Strategy*"
mvn test -Dtest="*Observer*"
mvn test -Dtest="*Decorator*"
mvn test -Dtest="*Adapter*"
```

Generate test coverage report:
```bash
mvn jacoco:report
```

## 📚 Pattern Examples

### Adapter Pattern
The Adapter pattern implementation demonstrates how incompatible interfaces can work together:
- **MediaPlayer** interface as the target interface that clients expect
- **AdvancedMediaPlayer** interface as the adaptee interface with a generic `play()` method
- **Mp4Player**, **VlcPlayer** as concrete adaptees that implement specific media formats
- **MediaAdapter** that bridges the gap between MediaPlayer and AdvancedMediaPlayer interfaces
- **AudioPlayer** as client that natively supports MP3 and uses adapters for other formats

**Key Features:**
- ✅ **SOLID Compliance**: Uses generic `play()` method instead of format-specific methods
- ✅ **Open/Closed Principle**: New formats can be added without modifying existing interfaces
- ✅ **Clean Architecture**: Simple, focused implementation without over-engineering
- ✅ **Real-world Scenario**: Media player with format compatibility through adapters

### Decorator Pattern
The Decorator pattern implementation includes:
- **Coffee** interface as the component
- **SimpleCoffee** as the concrete component
- **CoffeeDecorator** as the base decorator
- **MilkDecorator**, **SugarDecorator**, **WhipDecorator** as concrete decorators
- Dynamic behavior addition without altering structure

### Observer Pattern
The Observer pattern implementation includes:
- **Observer** interface for receiving notifications
- **Subject** interface for managing observers
- **NewsAgency** as concrete subject that publishes news
- **NewsSubscriber** as concrete observer that receives news
- Simple subscription/unsubscription mechanism

### Strategy Pattern
The Strategy pattern implementation includes:
- **PaymentStrategy** interface defining the contract
- **CreditCardPayment**, **PayPalPayment**, **BankTransferPayment** concrete strategies
- **PaymentContext** that uses strategies interchangeably
- Comprehensive validation and error handling
- Real-world payment processing simulation

### Singleton Pattern
- Thread-safe implementation using double-checked locking
- Protection against reflection-based instantiation
- Business logic demonstration

### Factory Pattern
- Shape creation factory with Circle, Rectangle implementations
- Type-safe enum-based factory method
- Extensible design for adding new shapes

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-pattern`)
3. Commit your changes (`git commit -am 'Add new pattern'`)
4. Push to the branch (`git push origin feature/new-pattern`)
5. Create a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🎯 Next Steps

After setup, you can:
1. Explore existing patterns in the `src/main/java/com/designpatterns/` directory
2. Run the demo classes to see patterns in action
3. Add your own pattern implementations
4. Write tests for new patterns
5. Extend existing patterns with new features

Happy coding! 🚀 