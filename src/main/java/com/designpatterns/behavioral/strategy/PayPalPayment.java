package com.designpatterns.behavioral.strategy;

/**
 * Concrete strategy implementation for PayPal payments.
 */
public class PayPalPayment implements PaymentStrategy {
    
    private final String email;
    private final double accountBalance;
    
    public PayPalPayment(String email, double accountBalance) {
        this.email = email;
        this.accountBalance = accountBalance;
    }
    
    @Override
    public boolean processPayment(double amount) {
        if (!validatePayment(amount)) {
            System.out.println("❌ PayPal payment validation failed for amount: $" + amount);
            return false;
        }
        
        System.out.println("🅿️ Processing PayPal payment...");
        System.out.println("   Account: " + email);
        System.out.println("   Amount: $" + amount);
        System.out.println("   Remaining balance: $" + (accountBalance - amount));
        
        // Simulate payment processing
        try {
            Thread.sleep(800); // Simulate network delay
            System.out.println("✅ PayPal payment of $" + amount + " processed successfully!");
            return true;
        } catch (InterruptedException e) {
            System.out.println("❌ PayPal payment processing interrupted");
            Thread.currentThread().interrupt();
            return false;
        }
    }
    
    @Override
    public String getPaymentMethodName() {
        return "PayPal";
    }
    
    @Override
    public boolean validatePayment(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid amount: $" + amount);
            return false;
        }
        
        if (amount > accountBalance) {
            System.out.println("❌ Insufficient PayPal balance. Required: $" + amount + 
                             ", Available: $" + accountBalance);
            return false;
        }
        
        if (!isValidEmail(email)) {
            System.out.println("❌ Invalid PayPal email format");
            return false;
        }
        
        return true;
    }
    
    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
    
    public String getEmail() {
        return email;
    }
    
    public double getAccountBalance() {
        return accountBalance;
    }
} 