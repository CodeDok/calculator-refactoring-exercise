package dev.codedok.operation;

/**
 * Cosecant operation implementation.
 * Follows the Single Responsibility Principle by only handling cosecant.
 */
public class CosecantOperation extends TrigOperation {
    
    public CosecantOperation(String equation) {
        super(equation, "csc");
    }
    
    @Override
    public double execute() {
        double sinValue = Math.sin(operand);
        if (sinValue == 0) {
            return Double.NaN; // Handle division by zero
        }
        return 1.0 / sinValue;
    }
    
    /**
     * Factory method to create an instance if this operation can handle the equation.
     * This implements the Factory Method Pattern.
     * 
     * @param equation The equation to check
     * @return A new instance if applicable, null otherwise
     */
    public static CosecantOperation createIfApplicable(String equation) {
        if (equation.indexOf("csc") != -1) {
            return new CosecantOperation(equation);
        }
        return null;
    }
} 