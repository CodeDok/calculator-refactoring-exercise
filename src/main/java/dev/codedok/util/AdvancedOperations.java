package dev.codedok.util;

public class AdvancedOperations {

    private AdvancedOperations() {}

    public static double exponent(String equation) {
        int operator = equation.indexOf("^");
        String operand1String = equation.substring(0,operator);
        String operand2String = equation.substring(operator+1);
        double operand1 = Double.parseDouble(operand1String);
        double operand2 = Double.parseDouble(operand2String);
        return Math.pow(operand1, operand2);
    }

    public static double mod(String equation) {
        int operator = equation.indexOf("%");
        double operand1 = Double.parseDouble(equation.substring(0,operator));
        double operand2 = Double.parseDouble(equation.substring(operator+1));
        if(operand2 == 0) {
            return Double.NaN;
        } else {
            return operand1 % operand2;
        }

    }

    public static double factorial(String equation) {
        int operator = equation.indexOf("!");
        long operand1 = (long) Double.parseDouble(equation.substring(0,operator));
        return factorial(operand1);
    }

    private static double factorial(double n) {
        if(n==0)
            return 1;
        return n * factorial(n-1);
    }

    public static double sigma(String equation) {
        int start = equation.indexOf("(");
        System.out.println(start);
        int operator2 = equation.indexOf(",");
        System.out.println(operator2);
        int end = equation.indexOf(")");
        System.out.println(end);
        long operand1 = (long) Double.parseDouble(equation.substring(start+1,operator2));
        double operand2 = (long) Double.parseDouble(equation.substring(operator2+1,end));
        return sigma(operand1,operand2);
    }

    private static double sigma(long max, double n) {
        if(n == max)
            return n;
        return sigma(max, n+1);
    }
}
