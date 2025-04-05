package dev.codedok.operation;

/**
 * Modulo operation implementation.
 * Follows the Single Responsibility Principle by only handling modulo.
 */
public class ModuloOperation extends BasicOperation {
    
    public ModuloOperation(String equation) {
        super(equation);
    }
    
    @Override
    public double execute() {
        if (operand2 == 0) {
            return Double.NaN; // Handle modulo by zero
        }
        return operand1 % operand2;
    }
    
    @Override
    protected int findOperatorIndex() {
        return equation.indexOf("%");
    }
    
    @Override
    public boolean canHandle(String equation) {
        return equation.indexOf("%") != -1;
    }
    
    /**
     * Factory method to create an instance if this operation can handle the equation.
     * This implements the Factory Method Pattern.
     * 
     * @param equation The equation to check
     * @return A new instance if applicable, null otherwise
     */
    public static ModuloOperation createIfApplicable(String equation) {
        if (equation.indexOf("%") != -1) {
            return new ModuloOperation(equation);
        }
        return null;
    }
} 