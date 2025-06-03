package com.designpatterns.behavioral.strategy;

/**
 * Demo class to demonstrate the Strategy pattern usage.
 * Shows how different payment strategies can be used interchangeably.
 */
public class StrategyDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern Demo ===\n");
        
        // Create payment context
        PaymentContext paymentContext = new PaymentContext();
        
        // Create different payment strategies
        PaymentStrategy creditCard = new CreditCardPayment(
            "1234567890123456", 
            "John Doe", 
            "12/25", 
            "123", 
            5000.0
        );
        
        PaymentStrategy paypal = new PayPalPayment(
            "john.doe@email.com", 
            1500.0
        );
        
        PaymentStrategy bankTransfer = new BankTransferPayment(
            "Chase Bank", 
            "9876543210", 
            "021000021", 
            10000.0
        );
        
        double purchaseAmount = 299.99;
        
        System.out.println("🛒 Purchase Amount: $" + purchaseAmount + "\n");
        
        // Demonstrate strategy switching at runtime
        demonstratePaymentStrategy(paymentContext, creditCard, purchaseAmount);
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        demonstratePaymentStrategy(paymentContext, paypal, purchaseAmount);
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        demonstratePaymentStrategy(paymentContext, bankTransfer, purchaseAmount);
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Demonstrate validation failures
        System.out.println("🧪 Testing Validation Scenarios:\n");
        
        // Test credit card limit exceeded
        PaymentStrategy limitedCreditCard = new CreditCardPayment(
            "1111222233334444", 
            "Jane Smith", 
            "06/26", 
            "456", 
            100.0  // Low credit limit
        );
        
        paymentContext.setPaymentStrategy(limitedCreditCard);
        System.out.println("Testing credit card with insufficient limit:");
        paymentContext.executePayment(purchaseAmount);
        
        System.out.println("\n" + "-".repeat(30) + "\n");
        
        // Test PayPal insufficient balance
        PaymentStrategy lowBalancePayPal = new PayPalPayment(
            "jane.smith@email.com", 
            50.0  // Low balance
        );
        
        paymentContext.setPaymentStrategy(lowBalancePayPal);
        System.out.println("Testing PayPal with insufficient balance:");
        paymentContext.executePayment(purchaseAmount);
        
        System.out.println("\n" + "-".repeat(30) + "\n");
        
        // Test bank transfer limit exceeded
        PaymentStrategy limitedBankTransfer = new BankTransferPayment(
            "Local Credit Union", 
            "1122334455", 
            "123456789", 
            200.0  // Low daily limit
        );
        
        paymentContext.setPaymentStrategy(limitedBankTransfer);
        System.out.println("Testing bank transfer with exceeded daily limit:");
        paymentContext.executePayment(purchaseAmount);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Demonstrate context without strategy
        System.out.println("🚫 Testing context without strategy:");
        PaymentContext emptyContext = new PaymentContext();
        try {
            emptyContext.executePayment(100.0);
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
        
        System.out.println("\n=== Strategy Pattern Demo Complete ===");
    }
    
    private static void demonstratePaymentStrategy(PaymentContext context, 
                                                 PaymentStrategy strategy, 
                                                 double amount) {
        context.setPaymentStrategy(strategy);
        
        System.out.println("💼 Current Payment Method: " + context.getCurrentPaymentMethod());
        System.out.println("✅ Strategy Set: " + context.hasPaymentStrategy());
        
        if (context.validatePayment(amount)) {
            System.out.println("✅ Payment validation passed");
            boolean success = context.executePayment(amount);
            System.out.println("Payment Result: " + (success ? "SUCCESS" : "FAILED"));
        } else {
            System.out.println("❌ Payment validation failed - payment not processed");
        }
    }
} 