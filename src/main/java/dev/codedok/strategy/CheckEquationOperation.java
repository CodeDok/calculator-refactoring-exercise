package dev.codedok.strategy;

public class CheckEquationOperation implements OperationStrategy {
    @Override
    public double calculate(String equation) {
        try {
            return Double.parseDouble(equation);
        } catch (Exception e) {
            return Double.NaN;
        }
    }
}
