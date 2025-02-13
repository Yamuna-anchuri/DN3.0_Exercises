public class SquareAdapter implements PaymentProcessor { 
    private Square square; 
 
    public SquareAdapter(Square square) { 
        this.square = square; 
    } 
 
    @Override 
    public void processPayment(double amount) { 
        square.charge(amount); 
    } 
}