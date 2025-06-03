package com.designpatterns.behavioral.strategy;

/**
 * Context class that uses PaymentStrategy.
 * This class maintains a reference to a strategy object and delegates 
 * the payment processing to the strategy.
 */
public class PaymentContext {
    
    private PaymentStrategy paymentStrategy;
    
    /**
     * Constructor that accepts a payment strategy.
     * 
     * @param paymentStrategy the payment strategy to use
     */
    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    /**
     * Default constructor - strategy must be set before use.
     */
    public PaymentContext() {
        this.paymentStrategy = null;
    }
    
    /**
     * Set or change the payment strategy at runtime.
     * 
     * @param paymentStrategy the new payment strategy
     */
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    /**
     * Execute payment using the current strategy.
     * 
     * @param amount the amount to pay
     * @return true if payment is successful, false otherwise
     * @throws IllegalStateException if no payment strategy is set
     */
    public boolean executePayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set. Please set a payment strategy before executing payment.");
        }
        
        System.out.println("🔄 Executing payment using " + paymentStrategy.getPaymentMethodName() + " strategy");
        return paymentStrategy.processPayment(amount);
    }
    
    /**
     * Validate payment using the current strategy.
     * 
     * @param amount the amount to validate
     * @return true if payment can be processed, false otherwise
     * @throws IllegalStateException if no payment strategy is set
     */
    public boolean validatePayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set. Please set a payment strategy before validating payment.");
        }
        
        return paymentStrategy.validatePayment(amount);
    }
    
    /**
     * Get the current payment method name.
     * 
     * @return the payment method name, or "None" if no strategy is set
     */
    public String getCurrentPaymentMethod() {
        return paymentStrategy != null ? paymentStrategy.getPaymentMethodName() : "None";
    }
    
    /**
     * Check if a payment strategy is currently set.
     * 
     * @return true if a strategy is set, false otherwise
     */
    public boolean hasPaymentStrategy() {
        return paymentStrategy != null;
    }
} 