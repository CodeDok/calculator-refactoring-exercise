package dev.codedok.operation;

/**
 * Abstract base class for binary operations.
 * Binary operations work with two operands and an operator symbol.
 */
public abstract class BinaryOperation implements Operation {
    /** The character symbol representing this operation (e.g., '+', '-') */
    protected final char operatorSymbol;

    /**
     * Creates a new binary operation with the given operator symbol.
     *
     * @param operatorSymbol The character that represents this operation
     */
    protected BinaryOperation(final char operatorSymbol) {
        this.operatorSymbol = operatorSymbol;
    }

    @Override
    public boolean canHandle(final String input) {
        return input.indexOf(operatorSymbol) != -1;
    }

    /**
     * Parses the input string to extract the two operands for this binary operation.
     *
     * @param input The input string containing the operation
     * @return An array of two doubles representing the operands
     */
    protected double[] parseOperands(final String input) {
        int operatorIndex = input.indexOf(operatorSymbol);
        double[] result = new double[2];
        
        // Handle special case for negative numbers
        if (operatorIndex == 0 && input.length() > 1) {
            // This is a negative number, find the next occurrence of the operator
            operatorIndex = input.indexOf(operatorSymbol, 1);
            if (operatorIndex == -1) {
                // No operator found, just parse as a number
                result[0] = Double.parseDouble(input);
                result[1] = 0;
                return result;
            }
        }
        
        final String operand1String = input.substring(0, operatorIndex).trim();
        final String operand2String = input.substring(operatorIndex + 1).trim();
        
        // Handle empty strings
        if (operand1String.isEmpty() || operand2String.isEmpty()) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }
        
        final double operand1 = Double.parseDouble(operand1String);
        final double operand2 = Double.parseDouble(operand2String);
        
        result[0] = operand1;
        result[1] = operand2;
        return result;
    }

    @Override
    public double execute(final String input) {
        double result;
        try {
            final double[] operands = parseOperands(input);
            result = calculate(operands[0], operands[1]);
        } catch (NumberFormatException e) {
            // Return NaN for any parsing errors
            result = Double.NaN;
        }
        return result;
    }

    /**
     * Performs the actual calculation with the two operands.
     * 
     * @param operand1 The first operand
     * @param operand2 The second operand
     * @return The result of applying this operation to the operands
     */
    protected abstract double calculate(double operand1, double operand2);
}