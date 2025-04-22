package dev.codedok;

import dev.codedok.operation.Operation;
import dev.codedok.operation.OperationRegistry;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Basic calculator implementation using the Strategy pattern
 * to handle different operations
 */
public class BasicCalculator implements Calculator {
    /** Registry containing all available operations */
    private final OperationRegistry registry;
    
    /** Logger for this class */
    private static final Logger LOGGER = Logger.getLogger(BasicCalculator.class.getName());
    
    /**
     * Creates a new calculator with the default operations
     */
    public BasicCalculator() {
        this.registry = new OperationRegistry();
    }
    
    /**
     * Creates a new calculator with the given operation registry
     * This constructor allows dependency injection for testing
     * 
     * @param registry The operation registry to use
     */
    public BasicCalculator(final OperationRegistry registry) {
        this.registry = registry;
    }
    
    @Override
    public double evaluate(final String expression) {
        double result = Double.NaN;
        
        if (expression == null || expression.isBlank()) {
            return result;
        }
        
        // Find an operation that can handle this expression
        final Operation operation = registry.findOperation(expression);
        
        if (operation != null) {
            result = operation.execute(expression);
        } else {
            // Try to parse as a simple number
            try {
                result = Double.parseDouble(expression);
            } catch (NumberFormatException e) {
                // Return NaN for unparseable expressions
                result = Double.NaN;
            }
        }
        
        return result;
    }
    
    /**
     * Main method to run the calculator interactively
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(final String[] args) {
        final Calculator calculator = new BasicCalculator();
        double lastValue;

        LOGGER.info("Enter a math problem: ");
        
        try (Scanner scanner = new Scanner(System.in)) {
            while(true) {
                LOGGER.info("\nEnter expression (or empty line to exit): ");
                
                if (!scanner.hasNext()) {
                    break;
                }
                
                final String fullEquation = scanner.nextLine();
                
                if (fullEquation.isEmpty()) {
                    break;
                }
                
                lastValue = calculator.evaluate(fullEquation);
                LOGGER.info(String.valueOf(lastValue));
            }
        } catch (IllegalStateException e) {
            LOGGER.log(Level.SEVERE, "Error reading input", e);
        }
    }
}