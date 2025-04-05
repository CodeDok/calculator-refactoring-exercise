package dev.codedok.operation;

/**
 * Division operation implementation.
 * Follows the Single Responsibility Principle by only handling division.
 */
public class DivisionOperation extends BasicOperation {
    
    public DivisionOperation(String equation) {
        super(equation);
    }
    
    @Override
    public double execute() {
        if (operand2 == 0) {
            return Double.NaN; // Handle division by zero
        }
        return operand1 / operand2;
    }
    
    @Override
    protected int findOperatorIndex() {
        return equation.indexOf("/");
    }
    
    @Override
    public boolean canHandle(String equation) {
        return equation.indexOf("/") != -1;
    }
    
    /**
     * Factory method to create an instance if this operation can handle the equation.
     * This implements the Factory Method Pattern.
     * 
     * @param equation The equation to check
     * @return A new instance if applicable, null otherwise
     */
    public static DivisionOperation createIfApplicable(String equation) {
        if (equation.indexOf("/") != -1) {
            return new DivisionOperation(equation);
        }
        return null;
    }
} 