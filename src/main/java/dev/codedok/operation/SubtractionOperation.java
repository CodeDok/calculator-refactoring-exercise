package dev.codedok.operation;

/**
 * Performs subtraction operation
 */
public class SubtractionOperation extends BinaryOperation {
    
    public SubtractionOperation() {
        super('-');
    }
    
    @Override
    protected double calculate(double operand1, double operand2) {
        return operand1 - operand2;
    }
}