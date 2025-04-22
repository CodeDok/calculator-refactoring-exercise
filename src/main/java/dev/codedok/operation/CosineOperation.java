package dev.codedok.operation;

/**
 * Implements cosine operation.
 * This class calculates the cosine of an angle.
 */
public class CosineOperation extends TrigonometricOperation {
    
    /**
     * Creates a new cosine operation.
     */
    public CosineOperation() {
        super("cos");
    }
    
    @Override
    protected double calculate(final double operand) {
        return Math.cos(operand);
    }
}