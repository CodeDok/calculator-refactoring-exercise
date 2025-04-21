package dev.codedok.expressions.base;

public abstract class Constant implements Expression {
    protected final double value;

    protected Constant(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    public abstract String getConstantSymbol();
}
