package dev.codedok.strategy;

public class FactorialOperation implements OperationStrategy{
    @Override
    public double calculate(String equation) {
        int operator = equation.indexOf("!");
        long operand1 = (long) Double.parseDouble(equation.substring(0,operator));
        return factorial(operand1);
    }

    private static double factorial(double n) {
        if(n==0)
            return 1;
        return n * factorial(n-1);
    }
}
