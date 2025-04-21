package dev.codedok.expressions.operators;

import dev.codedok.expressions.base.Expression;

public class Factorial implements Expression {
    private final Expression operand;

    public Factorial(Expression operand) {
        this.operand = operand;
    }

    @Override
    public double evaluate() {
        return factorial((int) operand.evaluate());
    }

    private static double factorial(int n) {
        if (n == 0)
            return 1;

        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
