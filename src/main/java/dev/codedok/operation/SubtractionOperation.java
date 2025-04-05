package dev.codedok.operation;

/**
 * Subtraction operation implementation.
 * Follows the Single Responsibility Principle by only handling subtraction.
 */
public class SubtractionOperation extends BasicOperation {
    
    public SubtractionOperation(String equation) {
        super(equation);
    }
    
    @Override
    public double execute() {
        return operand1 - operand2;
    }
    
    @Override
    protected int findOperatorIndex() {
        return equation.indexOf("-");
    }
    
    @Override
    public boolean canHandle(String equation) {
        return equation.indexOf("-") != -1;
    }
    
    /**
     * Factory method to create an instance if this operation can handle the equation.
     * This implements the Factory Method Pattern.
     * 
     * @param equation The equation to check
     * @return A new instance if applicable, null otherwise
     */
    public static SubtractionOperation createIfApplicable(String equation) {
        if (equation.indexOf("-") != -1 && !equation.startsWith("-")) {
            return new SubtractionOperation(equation);
        }
        return null;
    }
} 