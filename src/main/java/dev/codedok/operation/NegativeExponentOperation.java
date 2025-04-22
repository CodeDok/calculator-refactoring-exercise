package dev.codedok.operation;

/**
 * Specialized operation to handle negative exponents (e.g., 2^-3).
 * This class provides special handling for exponentiation with negative exponents.
 */
public class NegativeExponentOperation implements Operation {
    
    @Override
    public boolean canHandle(final String input) {
        return input.matches("\\d+\\^-\\d+"); // Matches pattern like "2^-3"
    }
    
    @Override
    public double execute(final String input) {
        final int caretIndex = input.indexOf('^');
        if (caretIndex <= 0 || caretIndex == input.length() - 1) {
            return Double.NaN;
        }
        
        try {
            final double base = Double.parseDouble(input.substring(0, caretIndex));
            final double exponent = Double.parseDouble(input.substring(caretIndex + 1));
            return Math.pow(base, exponent);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }
}