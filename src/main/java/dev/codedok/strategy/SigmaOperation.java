package dev.codedok.strategy;

public class SigmaOperation implements OperationStrategy{
    @Override
    public double calculate(String equation) {
        int start = equation.indexOf("(");
        System.out.println(start);
        int operator2 = equation.indexOf(",");
        System.out.println(operator2);
        int end = equation.indexOf(")");
        System.out.println(end);
        double operand1 = Double.parseDouble(equation.substring(start+1,operator2));
        double operand2 = Double.parseDouble(equation.substring(operator2+1,end));
        return sigma(operand1,operand2);
    }

    private static double sigma(double max, double n) {
        if(n == max)
            return n;
        return sigma(max, n+1);
    }
}
