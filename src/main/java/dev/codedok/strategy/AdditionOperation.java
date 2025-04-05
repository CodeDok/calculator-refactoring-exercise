package dev.codedok.strategy;

public class AdditionOperation implements OperationStrategy {
    @Override
    public double calculate(String equation) {
        int operatorIndex = equation.indexOf("+");
        double operand1 = Double.parseDouble(equation.substring(0,operatorIndex));
        double operand2 = Double.parseDouble(equation.substring(operatorIndex+1));
        return operand1 + operand2;
    }
}
