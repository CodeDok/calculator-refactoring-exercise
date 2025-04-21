package dev.codedok.expressions.functions;

import dev.codedok.expressions.base.Expression;
import dev.codedok.expressions.base.Function;

public class Sine extends Function {

    public Sine(Expression operand) {
        super(operand);
    }

    @Override
    public double evaluate() {
        return Math.sin(operand.evaluate());
    }

    @Override
    protected String getFunctionName() {
        return "sin";
    }
}
