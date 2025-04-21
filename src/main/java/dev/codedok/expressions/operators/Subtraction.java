package dev.codedok.expressions.operators;

import dev.codedok.expressions.base.BinaryOperator;
import dev.codedok.expressions.base.Expression;

public class Subtraction extends BinaryOperator {
    public Subtraction(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public double evaluate() {
        return leftOperand.evaluate() - rightOperand.evaluate();
    }

    @Override
    protected String getOperatorSymbol() {
        return "-";
    }
}