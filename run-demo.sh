#!/bin/bash

echo "🎯 Design Patterns Demo Runner"
echo "================================"

if [ $# -eq 0 ]; then
    echo "Available demos:"
    echo "  singleton       - Run Singleton Pattern Demo"
    echo "  factory         - Run Factory Pattern Demo"
    echo "  abstractfactory - Run Abstract Factory Pattern Demo"
    echo "  strategy        - Run Strategy Pattern Demo"
    echo "  observer        - Run Observer Pattern Demo"
    echo "  decorator       - Run Decorator Pattern Demo"
    echo ""
    echo "Usage: $0 <pattern-name>"
    echo "Example: $0 singleton"
    exit 1
fi

PATTERN=$1

case $PATTERN in
    "singleton")
        echo "🔧 Running Singleton Pattern Demo..."
        mvn exec:java -Dexec.mainClass="com.designpatterns.creational.singleton.SingletonDemo" -q
        ;;
    "factory")
        echo "🏭 Running Factory Pattern Demo..."
        mvn exec:java -Dexec.mainClass="com.designpatterns.creational.factory.FactoryDemo" -q
        ;;
    "abstractfactory")
        echo "🏭 Running Abstract Factory Pattern Demo..."
        mvn exec:java -Dexec.mainClass="com.designpatterns.creational.factory.abstractfactory.AbstractFactoryDemo" -q
        ;;
    "strategy")
        echo "💳 Running Strategy Pattern Demo..."
        mvn exec:java -Dexec.mainClass="com.designpatterns.behavioral.strategy.StrategyDemo" -q
        ;;
    "observer")
        echo "📰 Running Observer Pattern Demo..."
        mvn exec:java -Dexec.mainClass="com.designpatterns.behavioral.observer.ObserverDemo" -q
        ;;
    "decorator")
        echo "☕ Running Decorator Pattern Demo..."
        mvn exec:java -Dexec.mainClass="com.designpatterns.structural.decorator.DecoratorDemo" -q
        ;;
    *)
        echo "❌ Unknown pattern: $PATTERN"
        echo "Available patterns: singleton, factory, abstractfactory, strategy, observer, decorator"
        exit 1
        ;;
esac 