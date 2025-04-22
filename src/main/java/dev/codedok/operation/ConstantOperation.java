package dev.codedok.operation;

/**
 * Class representing mathematical constants
 */
public class ConstantOperation implements Operation {
    private final String constantName;
    private final double constantValue;
    
    public ConstantOperation(String constantName, double constantValue) {
        this.constantName = constantName;
        this.constantValue = constantValue;
    }
    
    @Override
    public boolean canHandle(String input) {
        return input.equalsIgnoreCase(constantName);
    }
    
    @Override
    public double execute(String input) {
        return constantValue;
    }
}