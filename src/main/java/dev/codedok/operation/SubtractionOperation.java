package dev.codedok.operation;

/**
 * Performs subtraction operation.
 * This class handles the subtraction of two numeric operands.
 */
public class SubtractionOperation extends BinaryOperation {
    
    /**
     * Creates a new subtraction operation using the minus sign (-) as operator.
     */
    public SubtractionOperation() {
        super('-');
    }
    
    @Override
    protected double calculate(final double operand1, final double operand2) {
        return operand1 - operand2;
    }
}