package dev.codedok.operation;

/**
 * Specialized operation to handle negative number multiplication (e.g., -2*-3).
 * This class provides special handling for multiplication where both operands are negative.
 */
public class NegativeMultiplicationOperation implements Operation {
    
    @Override
    public boolean canHandle(final String input) {
        return input.matches("-\\d+\\*-\\d+"); // Matches pattern like "-2*-3"
    }
    
    @Override
    public double execute(final String input) {
        final int starIndex = input.indexOf('*');
        if (starIndex <= 0) {
            return Double.NaN;
        }
        
        try {
            final double first = Double.parseDouble(input.substring(0, starIndex));
            final double second = Double.parseDouble(input.substring(starIndex + 1));
            return first * second;
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }
}