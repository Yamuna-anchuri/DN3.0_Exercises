public class FinancialForecasting { 
 
    // Method to calculate future value recursively 
    public double calculateFutureValue(double initialValue, double growthRate, int periods) 
{ 
        // Base case: no more periods to forecast 
        if (periods == 0) { 
            return initialValue; 
        } 
        // Recursive case: calculate future value 
        return calculateFutureValue(initialValue * (1 + growthRate), growthRate, periods - 1); 
    } 
 
    public static void main(String[] args) { 
        FinancialForecasting forecasting = new FinancialForecasting(); 
        double initialValue = 1000; // initial investment 
        double growthRate = 0.05; // 5% growth rate 
        int periods = 10; // forecast for 10 periods 
         
        double futureValue = forecasting.calculateFutureValue(initialValue, growthRate, 
periods); 
        System.out.println("Future Value: " + futureValue); 
    } 
} 