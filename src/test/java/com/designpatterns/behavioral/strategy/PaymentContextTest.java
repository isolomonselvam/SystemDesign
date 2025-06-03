package com.designpatterns.behavioral.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for PaymentContext class.
 */
class PaymentContextTest {

    private PaymentContext paymentContext;
    private PaymentStrategy mockStrategy;

    @BeforeEach
    void setUp() {
        paymentContext = new PaymentContext();
        // Create a simple mock strategy for testing
        mockStrategy = new PaymentStrategy() {
            @Override
            public boolean processPayment(double amount) {
                return amount > 0 && amount <= 1000;
            }

            @Override
            public String getPaymentMethodName() {
                return "Mock Payment";
            }

            @Override
            public boolean validatePayment(double amount) {
                return amount > 0 && amount <= 1000;
            }
        };
    }

    @Test
    @DisplayName("Should throw exception when executing payment without strategy")
    void testExecutePaymentWithoutStrategy() {
        IllegalStateException exception = assertThrows(
            IllegalStateException.class,
            () -> paymentContext.executePayment(100.0)
        );
        
        assertTrue(exception.getMessage().contains("Payment strategy not set"));
    }

    @Test
    @DisplayName("Should throw exception when validating payment without strategy")
    void testValidatePaymentWithoutStrategy() {
        IllegalStateException exception = assertThrows(
            IllegalStateException.class,
            () -> paymentContext.validatePayment(100.0)
        );
        
        assertTrue(exception.getMessage().contains("Payment strategy not set"));
    }

    @Test
    @DisplayName("Should successfully set and use payment strategy")
    void testSetAndUsePaymentStrategy() {
        paymentContext.setPaymentStrategy(mockStrategy);
        
        assertTrue(paymentContext.hasPaymentStrategy());
        assertEquals("Mock Payment", paymentContext.getCurrentPaymentMethod());
        assertTrue(paymentContext.validatePayment(100.0));
        assertTrue(paymentContext.executePayment(100.0));
    }

    @Test
    @DisplayName("Should handle strategy validation failure")
    void testStrategyValidationFailure() {
        paymentContext.setPaymentStrategy(mockStrategy);
        
        // Test amount that exceeds mock strategy limit
        assertFalse(paymentContext.validatePayment(2000.0));
        assertFalse(paymentContext.executePayment(2000.0));
    }

    @Test
    @DisplayName("Should return 'None' when no strategy is set")
    void testGetCurrentPaymentMethodWithoutStrategy() {
        assertEquals("None", paymentContext.getCurrentPaymentMethod());
        assertFalse(paymentContext.hasPaymentStrategy());
    }

    @Test
    @DisplayName("Should allow strategy switching at runtime")
    void testStrategySwitching() {
        // First strategy
        paymentContext.setPaymentStrategy(mockStrategy);
        assertEquals("Mock Payment", paymentContext.getCurrentPaymentMethod());
        
        // Switch to different strategy
        PaymentStrategy anotherStrategy = new PaymentStrategy() {
            @Override
            public boolean processPayment(double amount) {
                return true;
            }

            @Override
            public String getPaymentMethodName() {
                return "Another Payment";
            }

            @Override
            public boolean validatePayment(double amount) {
                return true;
            }
        };
        
        paymentContext.setPaymentStrategy(anotherStrategy);
        assertEquals("Another Payment", paymentContext.getCurrentPaymentMethod());
    }

    @Test
    @DisplayName("Should work with constructor that accepts strategy")
    void testConstructorWithStrategy() {
        PaymentContext contextWithStrategy = new PaymentContext(mockStrategy);
        
        assertTrue(contextWithStrategy.hasPaymentStrategy());
        assertEquals("Mock Payment", contextWithStrategy.getCurrentPaymentMethod());
        assertTrue(contextWithStrategy.executePayment(100.0));
    }
} 