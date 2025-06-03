# Strategy Pattern

## 📖 Overview

The Strategy Pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

## 🎯 Intent

- Define a family of algorithms, encapsulate each one, and make them interchangeable
- Strategy lets the algorithm vary independently from clients that use it
- Eliminate conditional statements in client code
- Support the Open/Closed Principle (open for extension, closed for modification)

## 🏗️ Structure

```
PaymentStrategy (Interface)
├── CreditCardPayment
├── PayPalPayment
└── BankTransferPayment

PaymentContext
└── Uses PaymentStrategy
```

## 🔧 Components

### 1. Strategy Interface (`PaymentStrategy`)
- Defines the contract that all concrete strategies must implement
- Contains methods: `processPayment()`, `getPaymentMethodName()`, `validatePayment()`

### 2. Concrete Strategies
- **CreditCardPayment**: Handles credit card transactions with credit limit validation
- **PayPalPayment**: Processes PayPal payments with account balance checks
- **BankTransferPayment**: Manages bank transfers with daily limit restrictions

### 3. Context (`PaymentContext`)
- Maintains a reference to a Strategy object
- Delegates payment processing to the current strategy
- Allows strategy switching at runtime

## 💡 Key Features

### Payment Processing Simulation
- **Credit Card**: Simulates card processing with masked card numbers
- **PayPal**: Shows account-based payments with balance tracking
- **Bank Transfer**: Demonstrates slower processing with business day notes

### Validation Logic
- Each strategy implements its own validation rules
- Credit limit checks for credit cards
- Balance verification for PayPal
- Daily transfer limits for bank transfers

### Error Handling
- Comprehensive validation before processing
- Graceful failure handling
- Informative error messages

## 🚀 Usage Example

```java
// Create payment context
PaymentContext paymentContext = new PaymentContext();

// Create different payment strategies
PaymentStrategy creditCard = new CreditCardPayment(
    "1234567890123456", "John Doe", "12/25", "123", 5000.0
);

PaymentStrategy paypal = new PayPalPayment(
    "john.doe@email.com", 1500.0
);

// Use credit card strategy
paymentContext.setPaymentStrategy(creditCard);
boolean success = paymentContext.executePayment(299.99);

// Switch to PayPal strategy at runtime
paymentContext.setPaymentStrategy(paypal);
success = paymentContext.executePayment(299.99);
```

## ✅ Advantages

1. **Runtime Algorithm Selection**: Switch between algorithms at runtime
2. **Open/Closed Principle**: Easy to add new payment methods without modifying existing code
3. **Elimination of Conditionals**: No need for large if-else or switch statements
4. **Testability**: Each strategy can be tested independently
5. **Reusability**: Strategies can be reused across different contexts

## ❌ Disadvantages

1. **Increased Number of Classes**: Each algorithm requires a separate class
2. **Client Awareness**: Clients must be aware of different strategies
3. **Communication Overhead**: Context and strategy need to communicate

## 🎭 Real-World Applications

- **Payment Processing**: Different payment gateways (Credit Card, PayPal, Bank Transfer)
- **Sorting Algorithms**: QuickSort, MergeSort, BubbleSort
- **Compression**: ZIP, RAR, 7Z compression algorithms
- **Authentication**: OAuth, LDAP, Database authentication
- **Pricing Strategies**: Regular, Premium, Discount pricing
- **File Export**: PDF, Excel, CSV export formats

## 🧪 Testing

The implementation includes comprehensive unit tests:

```bash
# Run Strategy pattern tests
mvn test -Dtest="*Strategy*"

# Run the demo
./run-demo.sh strategy
```

## 🔄 Extension Points

To add a new payment strategy:

1. Implement the `PaymentStrategy` interface
2. Add validation logic specific to your payment method
3. Implement the payment processing logic
4. Add tests for the new strategy
5. Update the demo to showcase the new strategy

Example:
```java
public class CryptocurrencyPayment implements PaymentStrategy {
    // Implementation details...
}
```

## 📚 Related Patterns

- **State Pattern**: Similar structure but different intent (behavior changes based on state)
- **Command Pattern**: Encapsulates requests as objects
- **Template Method**: Defines algorithm skeleton with varying steps
- **Factory Pattern**: Can be used to create strategy instances

## 🎯 When to Use

Use the Strategy pattern when:
- You have multiple ways to perform a task
- You want to avoid conditional statements
- You need to switch algorithms at runtime
- You want to isolate algorithm implementation details
- You need to support the Open/Closed Principle 