package dev.codedok.operation;

public class InvalidOperation implements MathOperation {
    @Override
    public boolean matches(String input) {
        return true; // fallback
    }

    @Override
    public double compute(String input) {
        return Double.NaN;
    }
}
