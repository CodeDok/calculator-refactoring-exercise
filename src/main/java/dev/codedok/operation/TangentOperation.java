package dev.codedok.operation;

/**
 * Implements tangent operation
 */
public class TangentOperation extends TrigonometricOperation {
    
    public TangentOperation() {
        super("tan");
    }
    
    @Override
    protected double calculate(double operand) {
        return Math.tan(operand);
    }
}