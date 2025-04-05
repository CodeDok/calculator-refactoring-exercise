package dev.codedok.operation;

/**
 * Secant operation implementation.
 * Follows the Single Responsibility Principle by only handling secant.
 */
public class SecantOperation extends TrigOperation {
    
    public SecantOperation(String equation) {
        super(equation, "sec");
    }
    
    @Override
    public double execute() {
        double cosValue = Math.cos(operand);
        if (cosValue == 0) {
            return Double.NaN; // Handle division by zero
        }
        return 1.0 / cosValue;
    }
    
    /**
     * Factory method to create an instance if this operation can handle the equation.
     * This implements the Factory Method Pattern.
     * 
     * @param equation The equation to check
     * @return A new instance if applicable, null otherwise
     */
    public static SecantOperation createIfApplicable(String equation) {
        if (equation.indexOf("sec") != -1) {
            return new SecantOperation(equation);
        }
        return null;
    }
} 