package dev.codedok.operation;

/**
 * Performs modulo operation.
 * This class handles the modulo (remainder) of two numeric operands.
 */
public class ModuloOperation extends BinaryOperation {
    
    /**
     * Creates a new modulo operation using the percent sign (%) as operator.
     */
    public ModuloOperation() {
        super('%');
    }
    
    @Override
    protected double calculate(final double operand1, final double operand2) {
        if (operand2 == 0) {
            return Double.NaN; // Modulo by zero results in NaN
        }
        return operand1 % operand2;
    }
}