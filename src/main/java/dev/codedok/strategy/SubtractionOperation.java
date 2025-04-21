package dev.codedok.strategy;

public class SubtractionOperation implements OperationStrategy {
    @Override
    public double calculate(String equation) {
        int operator = equation.indexOf("-");
        double operand1 = Double.parseDouble(equation.substring(0,operator));
        double operand2 = Double.parseDouble(equation.substring(operator+1));
        return operand1 - operand2;
    }
}
