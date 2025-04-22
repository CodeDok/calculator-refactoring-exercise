package dev.codedok.operation;

/**
 * Performs modulo operation
 */
public class ModuloOperation extends BinaryOperation {
    
    public ModuloOperation() {
        super('%');
    }
    
    @Override
    protected double calculate(double operand1, double operand2) {
        if (operand2 == 0) {
            return Double.NaN;
        }
        return operand1 % operand2;
    }
}