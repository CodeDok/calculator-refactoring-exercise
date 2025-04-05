package dev.codedok.operation;

/**
 * The Operation interface defines the contract for all mathematical operations.
 * Following the Interface Segregation Principle, this interface only contains
 * the essential method for any operation to execute.
 */
public interface Operation {
    /**
     * Executes the operation and returns the result.
     * 
     * @return The result of the operation
     */
    double execute();
    
    /**
     * Checks if this operation can handle the given equation string.
     * 
     * @param equation The equation to check
     * @return True if this operation can handle the equation, false otherwise
     */
    boolean canHandle(String equation);
} 