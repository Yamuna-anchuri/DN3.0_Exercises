public class TestStrategyPattern { 
    public static void main(String[] args) { 
        PaymentContext paymentContext = new PaymentContext(); 
 
        // Paying with Credit Card 
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John 
Doe"); 
        paymentContext.setPaymentStrategy(creditCardPayment); 
        paymentContext.executePayment(250.0); 
 
        // Paying with PayPal 
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com"); 
        paymentContext.setPaymentStrategy(payPalPayment); 
        paymentContext.executePayment(150.0); 
    } 
} 