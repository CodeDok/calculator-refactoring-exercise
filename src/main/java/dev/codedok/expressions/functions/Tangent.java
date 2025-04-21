package dev.codedok.expressions.functions;

import dev.codedok.expressions.base.Expression;
import dev.codedok.expressions.base.Function;

public class Tangent extends Function {

    public Tangent(Expression operand) {
        super(operand);
    }

    @Override
    public double evaluate() {
        return Math.tan(operand.evaluate());
    }

    @Override
    protected String getFunctionName() {
        return "tan";
    }
}