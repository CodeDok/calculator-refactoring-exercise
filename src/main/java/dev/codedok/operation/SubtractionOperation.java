package dev.codedok.operation;

public class SubtractionOperation implements MathOperation {
    @Override
    public boolean matches(String input) {
        // Match if there is a '-' that is not the first character and not part of a negative number after an operator
        // e.g. -2-3, 2-3, but not -2*-3 or 2^3
        int idx = input.indexOf("-", 1);
        if (idx == -1) return false;
        String left = input.substring(0, idx);
        // Exclude cases like "-2*-3" (should be handled by multiplication), or exponentiation
        if (left.contains("*") || left.contains("/") || left.contains("^") || left.contains("%") || left.isEmpty()) {
            return false;
        }
        // Also, ensure both sides are valid numbers
        try {
            Double.parseDouble(left);
            Double.parseDouble(input.substring(idx + 1));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public double compute(String input) {
        int operator = input.indexOf("-", 1);
        if (operator == -1) {
            // fallback, treat as a number
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                return Double.NaN;
            }
        }
        try {
            double operand1 = Double.parseDouble(input.substring(0, operator));
            double operand2 = Double.parseDouble(input.substring(operator + 1));
            return operand1 - operand2;
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }
}
