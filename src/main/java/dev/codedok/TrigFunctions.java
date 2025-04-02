package dev.codedok;

public class TrigFunctions {
    public static double sine(String equation) {

        int open = equation.indexOf("(");
        int close = equation.indexOf(")");
        double operand1 = Double.parseDouble(equation.substring(open+1,close));
        return Math.sin(operand1);

    }

    public static double cosine(String equation) {

        int open = equation.indexOf("(");
        int close = equation.indexOf(")");
        double operand1 = Double.parseDouble(equation.substring(open+1,close));
        return Math.cos(operand1);

    }

    public static double tangent(String equation) {

        int open = equation.indexOf("(");
        int close = equation.indexOf(")");
        double operand1 = Double.parseDouble(equation.substring(open+1,close));
        return Math.tan(operand1);

    }

    public static double cosecant(String equation) {

        int open = equation.indexOf("(");
        int close = equation.indexOf(")");
        double operand1 = Double.parseDouble(equation.substring(open+1,close));
        return 1.0 / Math.sin(operand1);

    }

    public static double secant(String equation) {

        int open = equation.indexOf("(");
        int close = equation.indexOf(")");
        double operand1 = Double.parseDouble(equation.substring(open+1,close));
        return 1.0 / Math.cos(operand1);

    }

    public static double cotangent(String equation) {

        int open = equation.indexOf("(");
        int close = equation.indexOf(")");
        double operand1 = Double.parseDouble(equation.substring(open+1,close));
        return 1.0 / Math.tan(operand1);

    }
}
