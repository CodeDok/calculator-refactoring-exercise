package dev.codedok.operations;

public class TrigFunctions {
    public static double sine(String equation) {
        double operand = determineOperand(equation);
        return Math.sin(operand);
    }

    public static double cosine(String equation) {
        double operand = determineOperand(equation);
        return Math.cos(operand);

    }

    public static double tangent(String equation) {
        double operand = determineOperand(equation);
        return Math.tan(operand);

    }

    public static double cosecant(String equation) {
        double operand = determineOperand(equation);
        return 1.0 / Math.sin(operand);

    }

    public static double secant(String equation) {
        double operand = determineOperand(equation);
        return 1.0 / Math.cos(operand);

    }

    public static double cotangent(String equation) {
        double operand = determineOperand(equation);
        return 1.0 / Math.tan(operand);
    }

    private static double determineOperand(String equation) {
        int open = equation.indexOf("(");
        int close = equation.indexOf(")");
        return Double.parseDouble(equation.substring(open + 1, close));
    }
}
