public class TestAdapterPattern { 
    public static void main(String[] args) { 
        // Creating instances of payment gateways 
        PayPal payPal = new PayPal(); 
        Stripe stripe = new Stripe(); 
        Square square = new Square(); 
 
        // Creating adapters 
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal); 
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe); 
        PaymentProcessor squareProcessor = new SquareAdapter(square); 
 
        // Processing payments through adapters 
        payPalProcessor.processPayment(100.0); 
        stripeProcessor.processPayment(200.0); 
        squareProcessor.processPayment(300.0); 
    } 
}