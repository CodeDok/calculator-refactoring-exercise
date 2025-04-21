package dev.codedok.strategy;

public class CosineOperation implements OperationStrategy {

    @Override
    public double calculate(String equation) {
        int open = equation.indexOf("(");
        int close = equation.indexOf(")");
        double operand1 = Double.parseDouble(equation.substring(open+1,close));
        return Math.cos(operand1);
    }
}
