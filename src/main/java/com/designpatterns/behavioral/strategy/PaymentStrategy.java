package com.designpatterns.behavioral.strategy;

/**
 * Strategy interface that defines the contract for all payment strategies.
 * This interface allows different payment methods to be used interchangeably.
 */
public interface PaymentStrategy {
    
    /**
     * Process the payment using the specific strategy implementation.
     * 
     * @param amount the amount to be paid
     * @return true if payment is successful, false otherwise
     */
    boolean processPayment(double amount);
    
    /**
     * Get the name of the payment method.
     * 
     * @return the payment method name
     */
    String getPaymentMethodName();
    
    /**
     * Validate if the payment method can process the given amount.
     * 
     * @param amount the amount to validate
     * @return true if the amount can be processed, false otherwise
     */
    boolean validatePayment(double amount);
} 