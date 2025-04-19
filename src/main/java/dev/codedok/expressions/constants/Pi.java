package dev.codedok.expressions.constants;

import dev.codedok.expressions.base.Constant;

public class Pi extends Constant {
    public static final double VALUE = Math.PI;
    public static final String SYMBOL = "Pi";

    public Pi() {
        super(VALUE);
    }

    @Override
    public String getConstantSymbol() {
        return SYMBOL;
    }

    @Override
    public String toString() {
        return SYMBOL;
    }
    
}
