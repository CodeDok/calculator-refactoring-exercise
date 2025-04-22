package dev.codedok.operation;

/**
 * Class representing mathematical constants.
 * This operation handles retrieving constant values like π and e.
 */
public class ConstantOperation implements Operation {
    /** The name of the constant, e.g., "pi" */
    private final String constantName;
    
    /** The value of the constant, e.g., 3.14159... */
    private final double constantValue;
    
    /**
     * Creates a new constant operation.
     * 
     * @param constantName The name of the constant
     * @param constantValue The value of the constant
     */
    public ConstantOperation(final String constantName, final double constantValue) {
        this.constantName = constantName;
        this.constantValue = constantValue;
    }
    
    @Override
    public boolean canHandle(final String input) {
        return input.equalsIgnoreCase(constantName);
    }
    
    @Override
    public double execute(final String input) {
        return constantValue;
    }
}