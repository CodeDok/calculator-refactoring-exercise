package dev.codedok.operation;

/**
 * Factorial operation implementation.
 * Follows the Single Responsibility Principle by only handling factorial.
 */
public class FactorialOperation implements Operation {
    private final String equation;
    private long operand;
    
    public FactorialOperation(String equation) {
        this.equation = equation;
        parseEquation();
    }
    
    private void parseEquation() {
        try {
            int operatorIndex = equation.indexOf("!");
            String operandStr = equation.substring(0, operatorIndex);
            operand = (long) Double.parseDouble(operandStr);
        } catch (Exception e) {
            operand = 0;
        }
    }
    
    @Override
    public double execute() {
        return factorial(operand);
    }
    
    private double factorial(double n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    @Override
    public boolean canHandle(String equation) {
        return equation.indexOf("!") != -1;
    }
    
    /**
     * Factory method to create an instance if this operation can handle the equation.
     * This implements the Factory Method Pattern.
     * 
     * @param equation The equation to check
     * @return A new instance if applicable, null otherwise
     */
    public static FactorialOperation createIfApplicable(String equation) {
        if (equation.indexOf("!") != -1) {
            return new FactorialOperation(equation);
        }
        return null;
    }
} 