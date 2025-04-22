package dev.codedok.operation;

/**
 * Implements tangent operation.
 * This class calculates the tangent of an angle.
 */
public class TangentOperation extends TrigonometricOperation {
    
    /**
     * Creates a new tangent operation.
     */
    public TangentOperation() {
        super("tan");
    }
    
    @Override
    protected double calculate(final double operand) {
        return Math.tan(operand);
    }
}