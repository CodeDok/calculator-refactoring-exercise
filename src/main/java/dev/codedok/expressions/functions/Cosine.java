package dev.codedok.expressions.functions;

import dev.codedok.expressions.base.Expression;
import dev.codedok.expressions.base.Function;

public class Cosine extends Function {

    public Cosine(Expression operand) {
        super(operand);
    }

    @Override
    public double evaluate() {
        return Math.cos(operand.evaluate());
    }

    @Override
    protected String getFunctionName() {
        return "cos";
    }
}