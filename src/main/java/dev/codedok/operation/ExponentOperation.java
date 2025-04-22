package dev.codedok.operation;

/**
 * Performs exponentiation operation.
 * This class handles raising one number to the power of another.
 */
public class ExponentOperation extends BinaryOperation {
    
    /**
     * Creates a new exponent operation using the caret (^) as operator.
     */
    public ExponentOperation() {
        super('^');
    }
    
    @Override
    protected double calculate(final double operand1, final double operand2) {
        return Math.pow(operand1, operand2);
    }
    
    @Override
    public double execute(final String input) {
        // Special handling for negative exponents
        final int operatorIndex = input.indexOf(operatorSymbol);
        if (operatorIndex < 0) {
            return Double.NaN;
        }
        
        try {
            final String leftPart = input.substring(0, operatorIndex).trim();
            final String rightPart = input.substring(operatorIndex + 1).trim();
            
            // Check for empty parts
            if (leftPart.isEmpty() || rightPart.isEmpty()) {
                return Double.NaN;
            }
            
            final double base = Double.parseDouble(leftPart);
            final double exponent = Double.parseDouble(rightPart);
            
            return Math.pow(base, exponent);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }
}