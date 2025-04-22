package dev.codedok.operation;

/**
 * Specialized operation to handle negative exponents (e.g., 2^-3)
 */
public class NegativeExponentOperation implements Operation {
    
    @Override
    public boolean canHandle(String input) {
        return input.matches("\\d+\\^-\\d+"); // Matches pattern like "2^-3"
    }
    
    @Override
    public double execute(String input) {
        int caretIndex = input.indexOf('^');
        if (caretIndex <= 0 || caretIndex == input.length() - 1) {
            return Double.NaN;
        }
        
        try {
            double base = Double.parseDouble(input.substring(0, caretIndex));
            double exponent = Double.parseDouble(input.substring(caretIndex + 1));
            return Math.pow(base, exponent);
        } catch (Exception e) {
            return Double.NaN;
        }
    }
}