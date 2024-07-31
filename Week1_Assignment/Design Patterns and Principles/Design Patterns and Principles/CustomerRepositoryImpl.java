public class CustomerRepositoryImpl implements CustomerRepository { 
    @Override 
    public Customer findCustomerById(int id) { 
        // In a real application, this would interact with a database to find the customer 
        // Here, we are simulating the behavior 
        return new Customer(id, "John Doe"); 
    } 
}