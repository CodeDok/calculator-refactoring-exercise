package dev.codedok.operation;

/**
 * Performs division operation
 */
public class DivisionOperation extends BinaryOperation {
    
    public DivisionOperation() {
        super('/');
    }
    
    @Override
    protected double calculate(double operand1, double operand2) {
        if (operand2 == 0) {
            return Double.NaN;
        }
        return operand1 / operand2;
    }
}