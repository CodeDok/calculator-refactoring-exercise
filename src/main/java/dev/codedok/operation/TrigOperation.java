package dev.codedok.operation;

import dev.codedok.TrigFunctions;

public class TrigOperation implements MathOperation {
    @Override
    public boolean matches(String input) {
        return input.startsWith("sin") || input.startsWith("cos") || input.startsWith("tan")
                || input.startsWith("csc") || input.startsWith("sec") || input.startsWith("cot");
    }

    @Override
    public double compute(String input) {
        if (input.startsWith("sin")) {
            return TrigFunctions.sine(input);
        } else if (input.startsWith("cos")) {
            return TrigFunctions.cosine(input);
        } else if (input.startsWith("tan")) {
            return TrigFunctions.tangent(input);
        } else if (input.startsWith("csc")) {
            return TrigFunctions.cosecant(input);
        } else if (input.startsWith("sec")) {
            return TrigFunctions.secant(input);
        } else if (input.startsWith("cot")) {
            return TrigFunctions.cotangent(input);
        }
        return Double.NaN;
    }
}
