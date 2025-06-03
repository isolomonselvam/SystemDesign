package com.designpatterns.behavioral.observer;

/**
 * Simple demo class to demonstrate the Observer pattern.
 */
public class ObserverDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Observer Pattern Demo ===\n");
        
        // Create the subject (news agency)
        NewsAgency newsAgency = new NewsAgency();
        
        // Create observers (subscribers)
        NewsSubscriber alice = new NewsSubscriber("Alice");
        NewsSubscriber bob = new NewsSubscriber("Bob");
        NewsSubscriber charlie = new NewsSubscriber("Charlie");
        
        // Subscribe to news
        System.out.println("📝 Subscribing users to news agency:\n");
        newsAgency.addObserver(alice);
        newsAgency.addObserver(bob);
        newsAgency.addObserver(charlie);
        
        System.out.println("\n" + "=".repeat(40) + "\n");
        
        // Publish some news
        newsAgency.publishNews("Breaking: New Java 21 features released!");
        
        System.out.println("\n" + "-".repeat(40) + "\n");
        
        newsAgency.publishNews("Tech: AI breakthrough in machine learning!");
        
        System.out.println("\n" + "-".repeat(40) + "\n");
        
        // Remove a subscriber
        System.out.println("🚪 Bob unsubscribes from news:");
        newsAgency.removeObserver(bob);
        
        System.out.println("\n" + "-".repeat(40) + "\n");
        
        // Publish more news (Bob won't receive this)
        newsAgency.publishNews("Sports: World Cup finals this weekend!");
        
        System.out.println("\n=== Observer Pattern Demo Complete ===");
    }
} 