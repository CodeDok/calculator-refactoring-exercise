package dev.codedok.operation;

/**
 * Performs addition operation
 */
public class AdditionOperation extends BinaryOperation {
    
    public AdditionOperation() {
        super('+');
    }
    
    @Override
    protected double calculate(double operand1, double operand2) {
        return operand1 + operand2;
    }
}