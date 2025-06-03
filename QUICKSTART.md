# Quick Start Guide

## 🚀 Initial Setup

### Prerequisites Installation

Since Java and Maven are not currently installed on your system, follow these steps:

1. **Run the setup script:**
   ```bash
   ./setup.sh
   ```

2. **Restart your terminal** or reload your shell configuration:
   ```bash
   source ~/.zshrc
   ```

3. **Verify installations:**
   ```bash
   java -version
   mvn -version
   ```

### Alternative Manual Installation

If you prefer to install manually:

1. **Install Homebrew** (if not already installed):
   ```bash
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```

2. **Install Java 17:**
   ```bash
   brew install openjdk@17
   ```

3. **Install Maven:**
   ```bash
   brew install maven
   ```

4. **Set environment variables** (add to `~/.zshrc`):
   ```bash
   export JAVA_HOME="/opt/homebrew/opt/openjdk@17"
   export PATH="/opt/homebrew/opt/openjdk@17/bin:$PATH"
   ```

## 🏗️ Building the Project

Once Java and Maven are installed:

1. **Compile the project:**
   ```bash
   mvn clean compile
   ```

2. **Run tests:**
   ```bash
   mvn test
   ```

3. **Package the project:**
   ```bash
   mvn package
   ```

## 🎯 Running Examples

### Singleton Pattern Demo
```bash
mvn exec:java -Dexec.mainClass="com.designpatterns.creational.singleton.SingletonDemo"
```

### Factory Pattern Demo
```bash
# Create a factory demo first, then run:
mvn exec:java -Dexec.mainClass="com.designpatterns.creational.factory.FactoryDemo"
```

## 📁 Project Structure Overview

```
Design/
├── src/
│   ├── main/
│   │   ├── java/com/designpatterns/
│   │   │   ├── creational/
│   │   │   │   ├── singleton/     # ✅ Complete
│   │   │   │   ├── factory/       # ✅ Basic implementation
│   │   │   │   ├── builder/       # 🚧 Ready for implementation
│   │   │   │   └── prototype/     # 🚧 Ready for implementation
│   │   │   ├── structural/        # 🚧 Ready for implementation
│   │   │   ├── behavioral/        # 🚧 Ready for implementation
│   │   │   └── system/            # 🚧 Ready for implementation
│   │   └── resources/
│   │       └── logback.xml        # ✅ Logging configuration
│   └── test/
│       └── java/com/designpatterns/
├── pom.xml                        # ✅ Maven configuration
├── README.md                      # ✅ Comprehensive documentation
├── setup.sh                       # ✅ Automated setup script
└── .gitignore                     # ✅ Git ignore rules
```

## 🧪 Testing

### Run all tests:
```bash
mvn test
```

### Run specific pattern tests:
```bash
mvn test -Dtest="*Singleton*"
mvn test -Dtest="*Factory*"
```

### Generate test reports:
```bash
mvn surefire-report:report
```

## 📚 Next Steps

1. **Explore existing patterns:**
   - Check out the Singleton implementation in `src/main/java/com/designpatterns/creational/singleton/`
   - Review the Factory pattern in `src/main/java/com/designpatterns/creational/factory/`

2. **Add new patterns:**
   - Use the existing structure as a template
   - Each pattern should have: implementation classes, demo class, and unit tests

3. **Extend current patterns:**
   - Add more shape types to the Factory pattern
   - Implement different Singleton variations (Enum-based, Bill Pugh, etc.)

4. **Implement system design patterns:**
   - Load Balancer
   - Circuit Breaker
   - Rate Limiter
   - Cache implementations

## 🔧 Development Tips

- **IDE Setup:** Import as a Maven project in your preferred IDE
- **Code Style:** Follow Java naming conventions and add comprehensive JavaDoc
- **Testing:** Write unit tests for all new patterns
- **Logging:** Use SLF4J for logging (already configured)

## 🐛 Troubleshooting

### Common Issues:

1. **Java not found:**
   - Ensure JAVA_HOME is set correctly
   - Restart terminal after installation

2. **Maven not found:**
   - Check if Maven is in your PATH
   - Reinstall using Homebrew

3. **Compilation errors:**
   - Ensure you're using Java 17+
   - Check for missing dependencies in pom.xml

### Getting Help:

- Check the main README.md for detailed documentation
- Review existing implementations for patterns
- Ensure all dependencies are properly configured in pom.xml

Happy coding! 🚀 