package dev.codedok;

/**
 * Interface for calculator implementations
 * Following the Dependency Inversion Principle
 */
@FunctionalInterface
public interface Calculator {
    /**
     * Evaluates the given expression and returns the result
     * @param expression The mathematical expression to evaluate
     * @return The result of the evaluation
     */
    double evaluate(String expression);
}