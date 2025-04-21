package dev.codedok.expressions.functions;

import dev.codedok.expressions.base.Expression;
import dev.codedok.expressions.base.Function;

public class Secant extends Function {

    public Secant(Expression operand) {
        super(operand);
    }

    @Override
    public double evaluate() {
        double value = operand.evaluate();
        return 1 / Math.cos(value);
    }

    @Override
    protected String getFunctionName() {
        return "sec";
    }
}