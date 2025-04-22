package dev.codedok.operation;

/**
 * Specialized operation to handle negative number multiplication (e.g., -2*-3)
 */
public class NegativeMultiplicationOperation implements Operation {
    
    @Override
    public boolean canHandle(String input) {
        return input.matches("-\\d+\\*-\\d+"); // Matches pattern like "-2*-3"
    }
    
    @Override
    public double execute(String input) {
        int starIndex = input.indexOf('*');
        if (starIndex <= 0) {
            return Double.NaN;
        }
        
        try {
            double first = Double.parseDouble(input.substring(0, starIndex));
            double second = Double.parseDouble(input.substring(starIndex + 1));
            return first * second;
        } catch (Exception e) {
            return Double.NaN;
        }
    }
}