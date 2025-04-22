package dev.codedok.operation;

/**
 * Implements sine operation.
 * This class calculates the sine of an angle.
 */
public class SineOperation extends TrigonometricOperation {
    
    /**
     * Creates a new sine operation.
     */
    public SineOperation() {
        super("sin");
    }
    
    @Override
    protected double calculate(final double operand) {
        return Math.sin(operand);
    }
}