package com.designpatterns.behavioral.strategy;

/**
 * Concrete strategy implementation for bank transfer payments.
 */
public class BankTransferPayment implements PaymentStrategy {
    
    private final String bankName;
    private final String accountNumber;
    private final String routingNumber;
    private final double dailyTransferLimit;
    
    public BankTransferPayment(String bankName, String accountNumber, 
                             String routingNumber, double dailyTransferLimit) {
        this.bankName = bankName;
        this.accountNumber = maskAccountNumber(accountNumber);
        this.routingNumber = routingNumber;
        this.dailyTransferLimit = dailyTransferLimit;
    }
    
    @Override
    public boolean processPayment(double amount) {
        if (!validatePayment(amount)) {
            System.out.println("❌ Bank transfer payment validation failed for amount: $" + amount);
            return false;
        }
        
        System.out.println("🏦 Processing bank transfer payment...");
        System.out.println("   Bank: " + bankName);
        System.out.println("   Account: " + accountNumber);
        System.out.println("   Routing: " + routingNumber);
        System.out.println("   Amount: $" + amount);
        
        // Simulate payment processing (bank transfers typically take longer)
        try {
            Thread.sleep(2000); // Simulate longer processing time
            System.out.println("✅ Bank transfer payment of $" + amount + " initiated successfully!");
            System.out.println("   Note: Transfer may take 1-3 business days to complete.");
            return true;
        } catch (InterruptedException e) {
            System.out.println("❌ Bank transfer payment processing interrupted");
            Thread.currentThread().interrupt();
            return false;
        }
    }
    
    @Override
    public String getPaymentMethodName() {
        return "Bank Transfer";
    }
    
    @Override
    public boolean validatePayment(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid amount: $" + amount);
            return false;
        }
        
        if (amount > dailyTransferLimit) {
            System.out.println("❌ Amount $" + amount + " exceeds daily transfer limit $" + dailyTransferLimit);
            return false;
        }
        
        // Bank transfers typically have minimum amounts
        if (amount < 1.00) {
            System.out.println("❌ Bank transfer minimum amount is $1.00");
            return false;
        }
        
        return true;
    }
    
    private String maskAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.length() < 4) {
            return "****";
        }
        return "****" + accountNumber.substring(accountNumber.length() - 4);
    }
    
    public String getBankName() {
        return bankName;
    }
    
    public double getDailyTransferLimit() {
        return dailyTransferLimit;
    }
} 