package com.designpatterns.behavioral.observer;

/**
 * Concrete Observer implementation - News Subscriber.
 */
public class NewsSubscriber implements Observer {
    
    private String name;
    
    public NewsSubscriber(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String message) {
        System.out.println("📱 " + name + " received news: " + message);
    }
    
    public String getName() {
        return name;
    }
} 