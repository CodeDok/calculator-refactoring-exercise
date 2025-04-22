package dev.codedok.operation;

/**
 * Abstract base class for unary operations (operations with one operand).
 * Unary operations work with a single operand and an operator symbol.
 */
public abstract class UnaryOperation implements Operation {
    /** The string symbol representing this operation (e.g., "sin", "cos") */
    protected final String operatorSymbol;

    /**
     * Creates a new unary operation with the given operator symbol.
     *
     * @param operatorSymbol The string that represents this operation
     */
    protected UnaryOperation(final String operatorSymbol) {
        this.operatorSymbol = operatorSymbol;
    }

    @Override
    public boolean canHandle(final String input) {
        return input.contains(operatorSymbol);
    }

    /**
     * Extracts the operand from the input string.
     *
     * @param input The input string containing the operation
     * @return The extracted operand as a double
     */
    protected abstract double parseOperand(final String input);

    @Override
    public double execute(final String input) {
        final double operand = parseOperand(input);
        return calculate(operand);
    }

    /**
     * Performs the actual calculation with the operand.
     *
     * @param operand The operand to calculate with
     * @return The result of applying this operation to the operand
     */
    protected abstract double calculate(double operand);
}