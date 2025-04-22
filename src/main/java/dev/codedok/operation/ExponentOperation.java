package dev.codedok.operation;

/**
 * Performs exponentiation operation
 */
public class ExponentOperation extends BinaryOperation {
    
    public ExponentOperation() {
        super('^');
    }
    
    @Override
    protected double calculate(double operand1, double operand2) {
        return Math.pow(operand1, operand2);
    }
    
    @Override
    public double execute(String input) {
        // Special handling for negative exponents
        int operatorIndex = input.indexOf(operatorSymbol);
        if (operatorIndex < 0) {
            return Double.NaN;
        }
        
        try {
            String leftPart = input.substring(0, operatorIndex).trim();
            String rightPart = input.substring(operatorIndex + 1).trim();
            
            // Check for empty parts
            if (leftPart.isEmpty() || rightPart.isEmpty()) {
                return Double.NaN;
            }
            
            double base = Double.parseDouble(leftPart);
            double exponent = Double.parseDouble(rightPart);
            
            return Math.pow(base, exponent);
        } catch (Exception e) {
            return Double.NaN;
        }
    }
}