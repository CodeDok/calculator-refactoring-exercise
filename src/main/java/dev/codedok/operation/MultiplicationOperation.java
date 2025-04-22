package dev.codedok.operation;

/**
 * Performs multiplication operation.
 * This class handles the multiplication of two numeric operands.
 */
public class MultiplicationOperation extends BinaryOperation {
    
    /**
     * Creates a new multiplication operation using the asterisk (*) as operator.
     */
    public MultiplicationOperation() {
        super('*');
    }
    
    @Override
    protected double calculate(final double operand1, final double operand2) {
        return operand1 * operand2;
    }
    
    @Override
    public double execute(final String input) {
        // Special handling for cases like -2*-3
        final int operatorIndex = input.indexOf(operatorSymbol);
        if (operatorIndex < 0) {
            return Double.NaN;
        }
        
        try {
            final String leftPart = input.substring(0, operatorIndex).trim();
            final String rightPart = input.substring(operatorIndex + 1).trim();
            
            // Handle the case of empty parts
            if (leftPart.isEmpty() || rightPart.isEmpty()) {
                return Double.NaN;
            }
            
            final double operand1 = Double.parseDouble(leftPart);
            final double operand2 = Double.parseDouble(rightPart);
            
            return operand1 * operand2;
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }
}