package dev.codedok.expressions.operators;

import dev.codedok.expressions.base.BinaryOperator;
import dev.codedok.expressions.base.Expression;

public class Exponent extends BinaryOperator {
    public Exponent(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public double evaluate() {
        return Math.pow(leftOperand.evaluate(), rightOperand.evaluate());
    }

    @Override
    protected String getOperatorSymbol() {
        return "^";
    }
}
