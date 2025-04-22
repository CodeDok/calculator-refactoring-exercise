package dev.codedok;

import dev.codedok.operation.Operation;
import dev.codedok.operation.OperationRegistry;

import java.util.Scanner;

/**
 * Basic calculator implementation using the Strategy pattern
 * to handle different operations
 */
public class BasicCalculator implements Calculator {
    private final OperationRegistry registry;
    
    /**
     * Creates a new calculator with the default operations
     */
    public BasicCalculator() {
        this.registry = new OperationRegistry();
    }
    
    /**
     * Creates a new calculator with the given operation registry
     * This constructor allows dependency injection for testing
     */
    public BasicCalculator(OperationRegistry registry) {
        this.registry = registry;
    }
    
    @Override
    public double evaluate(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return Double.NaN;
        }
        
        // Find an operation that can handle this expression
        Operation operation = registry.findOperation(expression);
        
        if (operation != null) {
            return operation.execute(expression);
        }
        
        // Try to parse as a simple number
        try {
            return Double.parseDouble(expression);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }
    
    /**
     * Main method to run the calculator interactively
     */
    public static void main(String[] args) {
        Calculator calculator = new BasicCalculator();
        double lastValue = 0;

        System.out.print("Enter a math problem: ");

        while(!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println();
                Scanner scan = new Scanner(System.in);
                if (!scan.hasNext()) {
                    continue;
                }

                String fullEquation = scan.nextLine();
                
                if (fullEquation.isEmpty()) {
                    continue;
                }

                lastValue = calculator.evaluate(fullEquation);
                System.out.print(lastValue);

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}