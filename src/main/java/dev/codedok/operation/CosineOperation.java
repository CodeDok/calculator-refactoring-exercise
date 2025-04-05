package dev.codedok.operation;

/**
 * Cosine operation implementation.
 * Follows the Single Responsibility Principle by only handling cosine.
 */
public class CosineOperation extends TrigOperation {
    
    public CosineOperation(String equation) {
        super(equation, "cos");
    }
    
    @Override
    public double execute() {
        return Math.cos(operand);
    }
    
    /**
     * Factory method to create an instance if this operation can handle the equation.
     * This implements the Factory Method Pattern.
     * 
     * @param equation The equation to check
     * @return A new instance if applicable, null otherwise
     */
    public static CosineOperation createIfApplicable(String equation) {
        if (equation.indexOf("cos") != -1) {
            return new CosineOperation(equation);
        }
        return null;
    }
} 