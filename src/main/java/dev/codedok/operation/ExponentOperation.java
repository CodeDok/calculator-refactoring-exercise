package dev.codedok.operation;

/**
 * Exponent operation implementation.
 * Follows the Single Responsibility Principle by only handling exponentiation.
 */
public class ExponentOperation extends BasicOperation {
    
    public ExponentOperation(String equation) {
        super(equation);
    }
    
    @Override
    public double execute() {
        return Math.pow(operand1, operand2);
    }
    
    @Override
    protected int findOperatorIndex() {
        return equation.indexOf("^");
    }
    
    @Override
    public boolean canHandle(String equation) {
        return equation.indexOf("^") != -1;
    }
    
    /**
     * Factory method to create an instance if this operation can handle the equation.
     * This implements the Factory Method Pattern.
     * 
     * @param equation The equation to check
     * @return A new instance if applicable, null otherwise
     */
    public static ExponentOperation createIfApplicable(String equation) {
        if (equation.indexOf("^") != -1) {
            return new ExponentOperation(equation);
        }
        return null;
    }
} 