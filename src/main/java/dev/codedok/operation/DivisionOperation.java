package dev.codedok.operation;

public class DivisionOperation implements MathOperation {
    @Override
    public boolean matches(String input) {
        // Only match if '/' is present and not at the start or end
        int idx = input.indexOf("/");
        return idx > 0 && idx < input.length() - 1;
    }

    @Override
    public double compute(String input) {
        int operator = input.indexOf("/");
        String left = input.substring(0, operator);
        String right = input.substring(operator + 1);
        double operand1 = Double.parseDouble(left);
        double operand2 = Double.parseDouble(right);
        if (operand2 == 0) {
            return Double.NaN;
        }
        return operand1 / operand2;
    }
}
