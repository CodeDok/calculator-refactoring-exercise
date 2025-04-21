package dev.codedok.operation;

public class NumberOperation implements MathOperation {
    @Override
    public boolean matches(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public double compute(String input) {
        try {
            return Double.parseDouble(input);
        } catch (Exception e) {
            return Double.NaN;
        }
    }
}
