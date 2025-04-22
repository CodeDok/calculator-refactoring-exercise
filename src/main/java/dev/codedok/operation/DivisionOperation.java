package dev.codedok.operation;

/**
 * Performs division operation.
 * This class handles the division of two numeric operands.
 */
public class DivisionOperation extends BinaryOperation {
    
    /**
     * Creates a new division operation using the forward slash (/) as operator.
     */
    public DivisionOperation() {
        super('/');
    }
    
    @Override
    protected double calculate(final double operand1, final double operand2) {
        if (operand2 == 0) {
            return Double.NaN; // Division by zero results in NaN
        }
        return operand1 / operand2;
    }
}