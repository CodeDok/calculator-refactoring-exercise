package dev.codedok.operation;

/**
 * Addition operation implementation.
 * Follows the Single Responsibility Principle by only handling addition.
 */
public class AdditionOperation extends BasicOperation {
    
    public AdditionOperation(String equation) {
        super(equation);
    }
    
    @Override
    public double execute() {
        return operand1 + operand2;
    }
    
    @Override
    protected int findOperatorIndex() {
        return equation.indexOf("+");
    }
    
    @Override
    public boolean canHandle(String equation) {
        return equation.indexOf("+") != -1;
    }
    
    /**
     * Factory method to create an instance if this operation can handle the equation.
     * This implements the Factory Method Pattern.
     * 
     * @param equation The equation to check
     * @return A new instance if applicable, null otherwise
     */
    public static AdditionOperation createIfApplicable(String equation) {
        if (equation.indexOf("+") != -1) {
            return new AdditionOperation(equation);
        }
        return null;
    }
} 