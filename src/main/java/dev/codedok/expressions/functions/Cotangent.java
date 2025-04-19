package dev.codedok.expressions.functions;

import dev.codedok.expressions.base.Expression;
import dev.codedok.expressions.base.Function;

public class Cotangent extends Function {

    public Cotangent(Expression operand) {
        super(operand);
    }

    @Override
    public double evaluate() {
        return 1.0 / Math.tan(operand.evaluate());
    }

    @Override
    protected String getFunctionName() {
        return "cot";
    }
}