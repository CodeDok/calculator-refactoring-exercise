package dev.codedok.expressions.functions;

import dev.codedok.expressions.base.Expression;
import dev.codedok.expressions.base.Function;

public class Cosecant extends Function {

    public Cosecant(Expression operand) {
        super(operand);
    }

    @Override
    public double evaluate() {
        double value = operand.evaluate();
        return 1 / Math.sin(value);
    }

    @Override
    protected String getFunctionName() {
        return "csc";
    }
}