package com.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject implementation - News Agency that publishes news.
 */
public class NewsAgency implements Subject {
    
    private List<Observer> observers;
    private String latestNews;
    
    public NewsAgency() {
        this.observers = new ArrayList<>();
    }
    
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        System.out.println("📰 New subscriber added. Total subscribers: " + observers.size());
    }
    
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("📰 Subscriber removed. Total subscribers: " + observers.size());
    }
    
    @Override
    public void notifyObservers(String message) {
        System.out.println("📢 Broadcasting news to " + observers.size() + " subscribers...");
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
    
    /**
     * Publish new news - this triggers notification to all observers.
     * 
     * @param news the news to publish
     */
    public void publishNews(String news) {
        this.latestNews = news;
        System.out.println("🗞️ News Agency: Publishing - " + news);
        notifyObservers(news);
    }
    
    public String getLatestNews() {
        return latestNews;
    }
} 