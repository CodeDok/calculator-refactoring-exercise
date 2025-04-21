package dev.codedok.strategy;

public class ModuloOperation implements OperationStrategy {
    @Override
    public double calculate(String equation) {
        int operator = equation.indexOf("%");
        double operand1 = Double.parseDouble(equation.substring(0,operator));
        double operand2 = Double.parseDouble(equation.substring(operator+1));
        if(operand2 == 0) {
            return Double.NaN;
        } else {
            return operand1 % operand2;
        }
    }
}
