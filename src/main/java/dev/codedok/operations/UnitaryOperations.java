package dev.codedok.operations;

public class UnitaryOperations {
    public static double factorial(String equation) {
        double operand = determineOperand(equation);
        return factorialRecursion((long) operand);
    }

    private static double factorialRecursion(long n) {
        if (n == 0)
            return 1;
        return n * factorialRecursion(n - 1);
    }

    public static void strangeOperation(String equation) {
        int start = equation.indexOf("(");
        System.out.println(start);
        int operator2 = equation.indexOf(",");
        System.out.println(operator2);
        int end = equation.indexOf(")");
        System.out.println(end);
    }

    private static double determineOperand(String equation) {
        int operatorIndex = equation.indexOf("!");
        return Double.parseDouble(equation.substring(0, operatorIndex));
    }
}
