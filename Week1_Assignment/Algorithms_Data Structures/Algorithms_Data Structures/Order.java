public class Order { 
    private String orderId; 
    private String customerName; 
    private double totalPrice; 
 
    // Constructor 
    public Order(String orderId, String customerName, double totalPrice) { 
        this.orderId = orderId; 
        this.customerName = customerName; 
        this.totalPrice = totalPrice; 
    } 
 
    // Getters 
    public String getOrderId() { return orderId; } 
    public String getCustomerName() { return customerName; } 
    public double getTotalPrice() { return totalPrice; } 
 
    // Setters 
    public void setOrderId(String orderId) { this.orderId = orderId; } 
    public void setCustomerName(String customerName) { this.customerName = 
customerName; } 
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; } 
}