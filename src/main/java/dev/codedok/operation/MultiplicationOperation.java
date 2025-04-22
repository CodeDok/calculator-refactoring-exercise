package dev.codedok.operation;

/**
 * Performs multiplication operation
 */
public class MultiplicationOperation extends BinaryOperation {
    
    public MultiplicationOperation() {
        super('*');
    }
    
    @Override
    protected double calculate(double operand1, double operand2) {
        return operand1 * operand2;
    }
    
    @Override
    public double execute(String input) {
        // Special handling for cases like -2*-3
        int operatorIndex = input.indexOf(operatorSymbol);
        if (operatorIndex < 0) {
            return Double.NaN;
        }
        
        try {
            String leftPart = input.substring(0, operatorIndex).trim();
            String rightPart = input.substring(operatorIndex + 1).trim();
            
            // Handle the case of empty parts
            if (leftPart.isEmpty() || rightPart.isEmpty()) {
                return Double.NaN;
            }
            
            double operand1 = Double.parseDouble(leftPart);
            double operand2 = Double.parseDouble(rightPart);
            
            return operand1 * operand2;
        } catch (Exception e) {
            return Double.NaN;
        }
    }
}