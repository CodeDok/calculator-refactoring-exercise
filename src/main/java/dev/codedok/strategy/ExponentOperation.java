package dev.codedok.strategy;

public class ExponentOperation implements OperationStrategy {
    @Override
    public double calculate(String equation) {
        int operator = equation.indexOf("^");
        String operand1String = equation.substring(0,operator);
        String operand2String = equation.substring(operator+1);
        double operand1 = Double.parseDouble(operand1String);
        double operand2 = Double.parseDouble(operand2String);
        return Math.pow(operand1, operand2);
    }
}
