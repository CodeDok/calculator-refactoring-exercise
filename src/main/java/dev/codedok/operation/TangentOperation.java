package dev.codedok.operation;

/**
 * Tangent operation implementation.
 * Follows the Single Responsibility Principle by only handling tangent.
 */
public class TangentOperation extends TrigOperation {
    
    public TangentOperation(String equation) {
        super(equation, "tan");
    }
    
    @Override
    public double execute() {
        return Math.tan(operand);
    }
    
    /**
     * Factory method to create an instance if this operation can handle the equation.
     * This implements the Factory Method Pattern.
     * 
     * @param equation The equation to check
     * @return A new instance if applicable, null otherwise
     */
    public static TangentOperation createIfApplicable(String equation) {
        if (equation.indexOf("tan") != -1) {
            return new TangentOperation(equation);
        }
        return null;
    }
} 