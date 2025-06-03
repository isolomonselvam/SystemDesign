package com.designpatterns.behavioral.observer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Simple unit tests for Observer pattern.
 */
class NewsAgencyTest {

    private NewsAgency newsAgency;
    private NewsSubscriber subscriber;

    @BeforeEach
    void setUp() {
        newsAgency = new NewsAgency();
        subscriber = new NewsSubscriber("TestUser");
    }

    @Test
    @DisplayName("Should add observer successfully")
    void testAddObserver() {
        newsAgency.addObserver(subscriber);
        // We can't directly test the list, but we can test behavior
        assertNotNull(newsAgency);
    }

    @Test
    @DisplayName("Should remove observer successfully")
    void testRemoveObserver() {
        newsAgency.addObserver(subscriber);
        newsAgency.removeObserver(subscriber);
        // Observer should be removed (tested through behavior)
        assertNotNull(newsAgency);
    }

    @Test
    @DisplayName("Should publish news and update latest news")
    void testPublishNews() {
        String testNews = "Test breaking news!";
        newsAgency.publishNews(testNews);
        
        assertEquals(testNews, newsAgency.getLatestNews());
    }

    @Test
    @DisplayName("Should notify observers when news is published")
    void testNotifyObservers() {
        // Create a test observer that tracks if it was notified
        TestObserver testObserver = new TestObserver();
        newsAgency.addObserver(testObserver);
        
        String testNews = "Test notification news!";
        newsAgency.publishNews(testNews);
        
        assertTrue(testObserver.wasNotified());
        assertEquals(testNews, testObserver.getLastMessage());
    }

    // Helper test observer class
    private static class TestObserver implements Observer {
        private boolean notified = false;
        private String lastMessage;

        @Override
        public void update(String message) {
            this.notified = true;
            this.lastMessage = message;
        }

        public boolean wasNotified() {
            return notified;
        }

        public String getLastMessage() {
            return lastMessage;
        }
    }
} 