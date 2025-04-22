package dev.codedok.operation;

/**
 * Implements sine operation
 */
public class SineOperation extends TrigonometricOperation {
    
    public SineOperation() {
        super("sin");
    }
    
    @Override
    protected double calculate(double operand) {
        return Math.sin(operand);
    }
}