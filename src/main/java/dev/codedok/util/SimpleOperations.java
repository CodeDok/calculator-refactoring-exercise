package dev.codedok.util;

public class SimpleOperations {

    private SimpleOperations() {}

    public static double addition(String equation) {
        int operator = equation.indexOf("+");
        double operand1 = Double.parseDouble(equation.substring(0,operator));
        double operand2 = Double.parseDouble(equation.substring(operator+1));
        return operand1 + operand2;
    }

    public static double subtraction (String equation) {
        int operator = equation.indexOf("-");
        double operand1 = Double.parseDouble(equation.substring(0,operator));
        double operand2 = Double.parseDouble(equation.substring(operator+1));
        return operand1 - operand2;
    }

    public static double multiplication(String equation) {
        int operator = equation.indexOf("*");
        double operand1 = Double.parseDouble(equation.substring(0,operator));
        double operand2 = Double.parseDouble(equation.substring(operator+1));
        return operand1 * operand2;
    }

    public static double division(String equation) {
        int operator = equation.indexOf("/");
        double operand1 = Double.parseDouble(equation.substring(0,operator));
        double operand2 = Double.parseDouble(equation.substring(operator+1));
        if(operand2 == 0) {
            return Double.NaN;
        } else {
            return operand1 / operand2;
        }
    }
}
