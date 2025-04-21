package dev.codedok.expressions.base;

public class Negation implements Expression {
    private final Expression expr;

    public Negation(Expression expr) {
        this.expr = expr;
    }

    @Override
    public double evaluate() {
        return -expr.evaluate();
    }
}
