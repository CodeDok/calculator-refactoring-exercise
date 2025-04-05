package dev.codedok.operation;

/**
 * Sine operation implementation.
 * Follows the Single Responsibility Principle by only handling sine.
 */
public class SineOperation extends TrigOperation {
    
    public SineOperation(String equation) {
        super(equation, "sin");
    }
    
    @Override
    public double execute() {
        return Math.sin(operand);
    }
    
    /**
     * Factory method to create an instance if this operation can handle the equation.
     * This implements the Factory Method Pattern.
     * 
     * @param equation The equation to check
     * @return A new instance if applicable, null otherwise
     */
    public static SineOperation createIfApplicable(String equation) {
        if (equation.indexOf("sin") != -1) {
            return new SineOperation(equation);
        }
        return null;
    }
} 