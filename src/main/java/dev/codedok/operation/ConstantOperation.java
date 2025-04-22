package dev.codedok.operation;

import dev.codedok.Constants;

public class ConstantOperation implements MathOperation {
    @Override
    public boolean matches(String input) {
        return input.equals("pi") || input.equals("e");
    }

    @Override
    public double compute(String input) {
        if (input.equals("pi")) {
            return Constants.pi();
        } else if (input.equals("e")) {
            return Constants.e();
        }
        return Double.NaN;
    }
}
