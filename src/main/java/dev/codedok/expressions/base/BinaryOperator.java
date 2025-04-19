package dev.codedok.expressions.base;

public abstract class BinaryOperator implements Expression {
    protected final Expression leftOperand;
    protected final Expression rightOperand;

    public BinaryOperator(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public abstract double evaluate();
    protected abstract String getOperatorSymbol();
}