public class Logger { 
    // Private static instance of the class (eager initialization) 
    private static final Logger instance = new Logger(); 
 
    // Private constructor to prevent instantiation 
    private Logger() { 
        // Private to prevent instantiation 
    } 
 
    // Public method to provide access to the instance 
    public static Logger getInstance() { 
        return instance; 
    } 
 
    
    public void log(String message) { 
        System.out.println("Log: " + message); 
    } 
}