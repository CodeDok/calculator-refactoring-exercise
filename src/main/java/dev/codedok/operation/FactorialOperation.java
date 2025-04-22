package dev.codedok.operation;

/**
 * Performs factorial operation (n!)
 */
public class FactorialOperation extends UnaryOperation {
    
    public FactorialOperation() {
        super("!");
    }
    
    @Override
    protected double parseOperand(String input) {
        int operatorIndex = input.indexOf(operatorSymbol);
        return Double.parseDouble(input.substring(0, operatorIndex));
    }
    
    @Override
    protected double calculate(double operand) {
        if (operand == 0) {
            return 1;
        }
        return operand * calculate(operand - 1);
    }
}