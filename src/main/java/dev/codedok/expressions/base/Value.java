package dev.codedok.expressions.base;

public class Value implements Expression {
    private final double value;

    public Value(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }
}
