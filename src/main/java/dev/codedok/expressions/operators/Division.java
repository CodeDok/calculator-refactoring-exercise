package dev.codedok.expressions.operators;

import dev.codedok.expressions.base.BinaryOperator;
import dev.codedok.expressions.base.Expression;

public class Division extends BinaryOperator {
    public Division(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public double evaluate() {
        if(rightOperand.evaluate() == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return leftOperand.evaluate() / rightOperand.evaluate();
    }

    @Override
    protected String getOperatorSymbol() {
        return "/";
    }
}