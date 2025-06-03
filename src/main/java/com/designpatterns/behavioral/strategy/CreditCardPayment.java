package com.designpatterns.behavioral.strategy;

/**
 * Concrete strategy implementation for credit card payments.
 */
public class CreditCardPayment implements PaymentStrategy {
    
    private final String cardNumber;
    private final String cardHolderName;
    private final String expiryDate;
    private final String cvv;
    private final double creditLimit;
    
    public CreditCardPayment(String cardNumber, String cardHolderName, 
                           String expiryDate, String cvv, double creditLimit) {
        this.cardNumber = maskCardNumber(cardNumber);
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.creditLimit = creditLimit;
    }
    
    @Override
    public boolean processPayment(double amount) {
        if (!validatePayment(amount)) {
            System.out.println("❌ Credit card payment validation failed for amount: $" + amount);
            return false;
        }
        
        System.out.println("💳 Processing credit card payment...");
        System.out.println("   Card: " + cardNumber);
        System.out.println("   Holder: " + cardHolderName);
        System.out.println("   Amount: $" + amount);
        
        // Simulate payment processing
        try {
            Thread.sleep(1000); // Simulate network delay
            System.out.println("✅ Credit card payment of $" + amount + " processed successfully!");
            return true;
        } catch (InterruptedException e) {
            System.out.println("❌ Credit card payment processing interrupted");
            Thread.currentThread().interrupt();
            return false;
        }
    }
    
    @Override
    public String getPaymentMethodName() {
        return "Credit Card";
    }
    
    @Override
    public boolean validatePayment(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid amount: $" + amount);
            return false;
        }
        
        if (amount > creditLimit) {
            System.out.println("❌ Amount $" + amount + " exceeds credit limit $" + creditLimit);
            return false;
        }
        
        // Additional validations could include:
        // - Card expiry date validation
        // - CVV validation
        // - Card number format validation
        
        return true;
    }
    
    private String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4) {
            return "****";
        }
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }
    
    public double getCreditLimit() {
        return creditLimit;
    }
} 