package dev.codedok;

import dev.codedok.operation.Operation;
import dev.codedok.operation.OperationFactory;

/**
 * Calculator class that handles mathematical operations.
 * Follows the Single Responsibility Principle by delegating the calculation
 * to the appropriate Operation objects.
 */
public class Calculator {
    
    private double lastValue;
    
    public Calculator() {
        this.lastValue = 0;
    }
    
    /**
     * Calculates the result of the given equation.
     * Uses the Strategy Pattern by delegating to different strategy implementations.
     * 
     * @param equation The equation to calculate
     * @return The result of the calculation
     */
    public double calculate(String equation) {
        if (equation == null || equation.trim().isEmpty()) {
            return lastValue;
        }
        
        try {
            Operation operation = OperationFactory.createOperation(equation);
            lastValue = operation.execute();
            return lastValue;
        } catch (Exception e) {
            return Double.NaN;
        }
    }
    
    /**
     * Gets the last calculated value.
     * 
     * @return The last calculated value
     */
    public double getLastValue() {
        return lastValue;
    }
} 