package dev.codedok.expressions.constants;
import dev.codedok.expressions.base.Constant;

public class Euler extends Constant {
    public static final double VALUE = Math.E;
    public static final String SYMBOL = "e";

    public Euler() {
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
