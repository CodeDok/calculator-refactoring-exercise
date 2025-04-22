package dev.codedok.operation;

/**
 * Performs addition operation.
 * This class handles the addition of two numeric operands.
 */
public class AdditionOperation extends BinaryOperation {
    
    /**
     * Creates a new addition operation using the plus sign (+) as operator.
     */
    public AdditionOperation() {
        super('+');
    }
    
    @Override
    protected double calculate(final double operand1, final double operand2) {
        return operand1 + operand2;
    }
}