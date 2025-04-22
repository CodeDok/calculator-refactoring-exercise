package dev.codedok.operation;

/**
 * Performs factorial operation (n!).
 * This class calculates the factorial of a number.
 */
public class FactorialOperation extends UnaryOperation {
    
    /**
     * Creates a new factorial operation using the exclamation mark (!) as operator.
     */
    public FactorialOperation() {
        super("!");
    }
    
    @Override
    protected double parseOperand(final String input) {
        final int operatorIndex = input.indexOf(operatorSymbol);
        return Double.parseDouble(input.substring(0, operatorIndex));
    }
    
    @Override
    protected double calculate(final double operand) {
        if (operand < 0) {
            return Double.NaN; // Factorial is not defined for negative numbers
        }
        
        if (operand == 0 || operand == 1) {
            return 1;
        }
        
        // For large numbers, use an iterative approach to avoid stack overflow
        if (operand > 20) {
            // For very large numbers, return Infinity to avoid precision issues
            return Double.POSITIVE_INFINITY;
        }
        
        double result = 1;
        for (int i = 2; i <= operand; i++) {
            result *= i;
        }
        return result;
    }
}