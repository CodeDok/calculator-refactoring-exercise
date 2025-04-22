package dev.codedok.operation;

/**
 * Base class for trigonometric operations
 */
public abstract class TrigonometricOperation extends UnaryOperation {
    
    protected TrigonometricOperation(String functionName) {
        super(functionName);
    }
    
    @Override
    protected double parseOperand(String input) {
        int openParenIndex = input.indexOf("(");
        int closeParenIndex = input.indexOf(")");
        
        if (openParenIndex == -1 || closeParenIndex == -1) {
            return Double.NaN;
        }
        
        try {
            String operandString = input.substring(openParenIndex + 1, closeParenIndex).trim();
            return Double.parseDouble(operandString);
        } catch (Exception e) {
            return Double.NaN;
        }
    }
}