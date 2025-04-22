package dev.codedok.operation;

import dev.codedok.Constants;
import java.util.ArrayList;
import java.util.List;

/**
 * Registry for all operations supported by the calculator
 * Follows the Open-Closed Principle by allowing new operations
 * to be added without changing existing code
 */
public class OperationRegistry {
    private final List<Operation> operations = new ArrayList<>();
    
    /**
     * Creates a new registry with default operations
     */
    public OperationRegistry() {
        registerDefaultOperations();
    }
    
    /**
     * Registers a new operation
     */
    public void register(Operation operation) {
        operations.add(operation);
    }
    
    /**
     * Finds the first operation that can handle the given input
     * @return The operation or null if no operation can handle it
     */
    public Operation findOperation(String input) {
        for (Operation operation : operations) {
            if (operation.canHandle(input)) {
                return operation;
            }
        }
        return null;
    }
    
    /**
     * Registers the default set of operations
     */
    private void registerDefaultOperations() {
        // Special case handlers - register these first for precedence
        register(new NegativeMultiplicationOperation());
        register(new NegativeExponentOperation());
        
        // Binary operations
        register(new AdditionOperation());
        register(new SubtractionOperation());
        register(new MultiplicationOperation());
        register(new DivisionOperation());
        register(new ModuloOperation());
        register(new ExponentOperation());
        
        // Unary operations
        register(new FactorialOperation());
        
        // Trigonometric operations
        register(new SineOperation());
        register(new CosineOperation());
        register(new TangentOperation());
        
        // Constants
        register(new ConstantOperation("pi", Constants.pi()));
        register(new ConstantOperation("e", Constants.e()));
    }
}