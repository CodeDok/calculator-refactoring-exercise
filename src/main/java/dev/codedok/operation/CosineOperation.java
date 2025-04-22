package dev.codedok.operation;

/**
 * Implements cosine operation
 */
public class CosineOperation extends TrigonometricOperation {
    
    public CosineOperation() {
        super("cos");
    }
    
    @Override
    protected double calculate(double operand) {
        return Math.cos(operand);
    }
}