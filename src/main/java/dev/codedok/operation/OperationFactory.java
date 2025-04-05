package dev.codedok.operation;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory class for creating Operation objects.
 * Implements the Factory Pattern.
 */
public class OperationFactory {
    
    /**
     * Creates an appropriate Operation based on the equation.
     * 
     * @param equation The equation to parse
     * @return An appropriate Operation instance
     */
    public static Operation createOperation(String equation) {
        // Order of operations precedence
        Operation operation;
        
        // Check for constants first
        operation = ConstantOperation.createIfApplicable(equation);
        if (operation != null) {
            return operation;
        }
        
        // Exponents
        operation = ExponentOperation.createIfApplicable(equation);
        if (operation != null) {
            return operation;
        }
        
        // Multiplication, Division, Modulo
        operation = MultiplicationOperation.createIfApplicable(equation);
        if (operation != null) {
            return operation;
        }
        
        operation = DivisionOperation.createIfApplicable(equation);
        if (operation != null) {
            return operation;
        }
        
        operation = ModuloOperation.createIfApplicable(equation);
        if (operation != null) {
            return operation;
        }
        
        // Addition, Subtraction
        operation = AdditionOperation.createIfApplicable(equation);
        if (operation != null) {
            return operation;
        }
        
        operation = SubtractionOperation.createIfApplicable(equation);
        if (operation != null) {
            return operation;
        }
        
        // Trig functions
        operation = SineOperation.createIfApplicable(equation);
        if (operation != null) {
            return operation;
        }
        
        operation = CosineOperation.createIfApplicable(equation);
        if (operation != null) {
            return operation;
        }
        
        operation = TangentOperation.createIfApplicable(equation);
        if (operation != null) {
            return operation;
        }
        
        operation = CosecantOperation.createIfApplicable(equation);
        if (operation != null) {
            return operation;
        }
        
        operation = SecantOperation.createIfApplicable(equation);
        if (operation != null) {
            return operation;
        }
        
        operation = CotangentOperation.createIfApplicable(equation);
        if (operation != null) {
            return operation;
        }
        
        // Advanced operations
        operation = FactorialOperation.createIfApplicable(equation);
        if (operation != null) {
            return operation;
        }
        
        // Default - treat as a number
        return new ConstantOperation(equation, "number");
    }
} 