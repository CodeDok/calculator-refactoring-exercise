package dev.codedok.operation;

/**
 * Interface for all calculator operations
 */
public interface Operation {
    /**
     * Executes the operation on the given input
     * @param input The input string to process
     * @return The result of the operation
     */
    double execute(String input);
    
    /**
     * Checks if this operation can handle the given input
     * @param input The input to check
     * @return true if the operation can handle the input, false otherwise
     */
    boolean canHandle(String input);
}