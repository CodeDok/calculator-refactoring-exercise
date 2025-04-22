package dev.codedok.operation;

/**
 * Base class for trigonometric operations.
 * This class provides common functionality for sine, cosine, tangent and other
 * trigonometric operations.
 */
public abstract class TrigonometricOperation extends UnaryOperation {
    
    /**
     * Creates a new trigonometric operation with the given function name.
     * 
     * @param functionName The name of the trigonometric function (e.g., "sin", "cos")
     */
    protected TrigonometricOperation(final String functionName) {
        super(functionName);
    }
    
    @Override
    protected double parseOperand(final String input) {
        final int openParenIndex = input.indexOf('(');
        final int closeParenIndex = input.indexOf(')');
        
        if (openParenIndex == -1 || closeParenIndex == -1) {
            return Double.NaN;
        }
        
        try {
            final String operandString = input.substring(openParenIndex + 1, closeParenIndex).trim();
            return Double.parseDouble(operandString);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }
}