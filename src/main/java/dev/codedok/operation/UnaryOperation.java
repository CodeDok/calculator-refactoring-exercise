package dev.codedok.operation;

/**
 * Abstract base class for unary operations (operations with one operand)
 */
public abstract class UnaryOperation implements Operation {
    protected final String operatorSymbol;

    protected UnaryOperation(String operatorSymbol) {
        this.operatorSymbol = operatorSymbol;
    }

    @Override
    public boolean canHandle(String input) {
        return input.contains(operatorSymbol);
    }

    /**
     * Extracts the operand from the input string
     */
    protected abstract double parseOperand(String input);

    @Override
    public double execute(String input) {
        double operand = parseOperand(input);
        return calculate(operand);
    }

    /**
     * Performs the actual calculation with the operand
     */
    protected abstract double calculate(double operand);
}