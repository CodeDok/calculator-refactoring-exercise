package dev.codedok.operation;

public class ExponentOperation implements MathOperation {
    @Override
    public boolean matches(String input) {
        // Only match if '^' is present and not at the start or end
        int idx = input.indexOf("^");
        // Also ensure both sides of ^ are valid numbers
        if (idx > 0 && idx < input.length() - 1) {
            try {
                Double.parseDouble(input.substring(0, idx));
                Double.parseDouble(input.substring(idx + 1));
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public double compute(String input) {
        int operator = input.indexOf("^");
        String operand1String = input.substring(0, operator);
        String operand2String = input.substring(operator + 1);

        try {
            double operand1 = Double.parseDouble(operand1String);
            double operand2 = Double.parseDouble(operand2String);
            return Math.pow(operand1, operand2);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }
}
