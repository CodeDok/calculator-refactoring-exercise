package dev.codedok.expressions.base;

public abstract class Function implements Expression {
    protected final Expression operand;

    public Function(Expression operand) {
        this.operand = operand;
    }

    public abstract double evaluate();
    protected abstract String getFunctionName();
}
