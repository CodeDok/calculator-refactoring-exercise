package dev.codedok.operation;

/**
 * Cotangent operation implementation.
 * Follows the Single Responsibility Principle by only handling cotangent.
 */
public class CotangentOperation extends TrigOperation {
    
    public CotangentOperation(String equation) {
        super(equation, "cot");
    }
    
    @Override
    public double execute() {
        double tanValue = Math.tan(operand);
        if (tanValue == 0) {
            return Double.NaN; // Handle division by zero
        }
        return 1.0 / tanValue;
    }
    
    /**
     * Factory method to create an instance if this operation can handle the equation.
     * This implements the Factory Method Pattern.
     * 
     * @param equation The equation to check
     * @return A new instance if applicable, null otherwise
     */
    public static CotangentOperation createIfApplicable(String equation) {
        if (equation.indexOf("cot") != -1) {
            return new CotangentOperation(equation);
        }
        return null;
    }
} 