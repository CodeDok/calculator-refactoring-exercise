package dev.codedok.operation;

/**
 * Abstract base class for binary operations
 */
public abstract class BinaryOperation implements Operation {
    protected final char operatorSymbol;

    protected BinaryOperation(char operatorSymbol) {
        this.operatorSymbol = operatorSymbol;
    }

    @Override
    public boolean canHandle(String input) {
        return input.indexOf(operatorSymbol) != -1;
    }

    protected double[] parseOperands(String input) {
        int operatorIndex = input.indexOf(operatorSymbol);
        
        // Handle special case for negative numbers
        if (operatorIndex == 0 && input.length() > 1) {
            // This is a negative number, find the next occurrence of the operator
            operatorIndex = input.indexOf(operatorSymbol, 1);
            if (operatorIndex == -1) {
                // No operator found, just parse as a number
                return new double[] { Double.parseDouble(input), 0 };
            }
        }
        
        String operand1String = input.substring(0, operatorIndex).trim();
        String operand2String = input.substring(operatorIndex + 1).trim();
        
        // Handle empty strings
        if (operand1String.isEmpty() || operand2String.isEmpty()) {
            return new double[] { 0, 0 };
        }
        
        double operand1 = Double.parseDouble(operand1String);
        double operand2 = Double.parseDouble(operand2String);
        
        return new double[] { operand1, operand2 };
    }

    @Override
    public double execute(String input) {
        try {
            double[] operands = parseOperands(input);
            return calculate(operands[0], operands[1]);
        } catch (Exception e) {
            // Return NaN for any parsing errors
            return Double.NaN;
        }
    }

    /**
     * Performs the actual calculation with the two operands
     */
    protected abstract double calculate(double operand1, double operand2);
}