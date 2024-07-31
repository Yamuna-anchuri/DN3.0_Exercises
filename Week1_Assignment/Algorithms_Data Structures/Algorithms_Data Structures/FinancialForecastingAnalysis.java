public class FinancialForecasting { 
 
    // Method to calculate future value iteratively 
    public double calculateFutureValueIterative(double initialValue, double growthRate, int 
periods) { 
        double futureValue = initialValue; 
        for (int i = 0; i < periods; i++) { 
            futureValue *= (1 + growthRate); 
        } 
        return futureValue; 
    } 
 
    public static void main(String[] args) { 
        FinancialForecasting forecasting = new FinancialForecasting(); 
        double initialValue = 1000; // initial investment 
        double growthRate = 0.05; // 5% growth rate 
        int periods = 10; // forecast for 10 periods 
         
        double futureValueRecursive = forecasting.calculateFutureValue(initialValue, 
growthRate, periods); 
        double futureValueIterative = forecasting.calculateFutureValueIterative(initialValue, 
growthRate, periods); 
 
        System.out.println("Future Value (Recursive): " + futureValueRecursive); 
        System.out.println("Future Value (Iterative): " + futureValueIterative); 
    } 
}