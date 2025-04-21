package dev.codedok.operations;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BinaryOperations {
    public static double exponent(String equation) {
        BinaryOperands operands = determineBinaryOperands(equation, "^");
        return Math.pow(operands.operand1, operands.operand2);
    }

    public static double multiplication(String equation) {
        BinaryOperands operands = determineBinaryOperands(equation, "*");
        return operands.operand1() * operands.operand2();

    }

    public static double division(String equation) {
        BinaryOperands operands = determineBinaryOperands(equation, "/");
        if (operands.operand2 == 0) {
            return Double.NaN;
        } else {
            return operands.operand1 / operands.operand2;
        }
    }

    private static BinaryOperands determineBinaryOperands(String equation, String operator) {
        double[] operands = Arrays.stream(equation.split(Pattern.quote(operator)))
                .mapToDouble(Double::parseDouble)
                .toArray();
        return new BinaryOperands(operands[0], operands[1]);
    }

    private record BinaryOperands(double operand1, double operand2) {

    }

    public static double addition(String equation) {
        BinaryOperands operands = determineBinaryOperands(equation, "+");
        return operands.operand1 + operands.operand2;
    }

    public static double subtraction(String equation) {
        BinaryOperands operands = determineBinaryOperands(equation, "-");
        return operands.operand1 - operands.operand2;
    }

    public static double mod(String equation) {
        BinaryOperands operands = determineBinaryOperands(equation, "%");
        if (operands.operand2 == 0) {
            return Double.NaN;
        } else {
            return operands.operand1 % operands.operand2;
        }

    }
}
