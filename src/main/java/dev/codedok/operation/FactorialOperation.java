package dev.codedok.operation;

public class FactorialOperation implements MathOperation {
    @Override
    public boolean matches(String input) {
        return input.contains("!");
    }

    @Override
    public double compute(String input) {
        int operator = input.indexOf("!");
        long operand1 = (long) Double.parseDouble(input.substring(0, operator));
        return factorial(operand1);
    }

    private double factorial(long n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
