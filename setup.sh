#!/bin/bash

echo "🚀 Setting up Java Design Patterns Project"
echo "=========================================="

# Check if Homebrew is installed
if ! command -v brew &> /dev/null; then
    echo "❌ Homebrew not found. Installing Homebrew..."
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
else
    echo "✅ Homebrew is already installed"
fi

# Update Homebrew
echo "🔄 Updating Homebrew..."
brew update

# Install Java 17 (OpenJDK)
if ! command -v java &> /dev/null; then
    echo "📦 Installing Java 17 (OpenJDK)..."
    brew install openjdk@17
    
    # Add Java to PATH
    echo 'export PATH="/opt/homebrew/opt/openjdk@17/bin:$PATH"' >> ~/.zshrc
    echo 'export JAVA_HOME="/opt/homebrew/opt/openjdk@17"' >> ~/.zshrc
    
    # For Intel Macs, use different path
    if [[ $(uname -m) == 'x86_64' ]]; then
        echo 'export PATH="/usr/local/opt/openjdk@17/bin:$PATH"' >> ~/.zshrc
        echo 'export JAVA_HOME="/usr/local/opt/openjdk@17"' >> ~/.zshrc
    fi
    
    source ~/.zshrc
else
    echo "✅ Java is already installed"
fi

# Install Maven
if ! command -v mvn &> /dev/null; then
    echo "📦 Installing Maven..."
    brew install maven
else
    echo "✅ Maven is already installed"
fi

# Create logs directory
mkdir -p logs

echo ""
echo "🎉 Setup completed!"
echo ""
echo "📋 Next steps:"
echo "1. Restart your terminal or run: source ~/.zshrc"
echo "2. Verify installation:"
echo "   java -version"
echo "   mvn -version"
echo "3. Compile the project:"
echo "   mvn clean compile"
echo "4. Run tests:"
echo "   mvn test"
echo "5. Run the Singleton demo:"
echo "   mvn exec:java -Dexec.mainClass=\"com.designpatterns.creational.singleton.SingletonDemo\""
echo ""
echo "📚 Project structure is ready with:"
echo "   - Singleton pattern (complete with tests)"
echo "   - Factory pattern (basic implementation)"
echo "   - Maven configuration"
echo "   - Logging setup"
echo "   - Test framework (JUnit 5)"
echo ""
echo "Happy coding! 🚀" 