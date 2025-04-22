package dev.codedok;

/**
 * Utility class that provides trigonometric functions for the calculator.
 * This class handles calculations for sine, cosine, tangent and their reciprocals.
 */
public final class TrigFunctions {
    
    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private TrigFunctions() {
        // Utility class should not be instantiated
    }
    
    /**
     * Calculates the sine of an angle given in the equation.
     * 
     * @param equation The equation containing the angle in parentheses, e.g. "sin(0.5)"
     * @return The sine of the angle
     */
    public static double sine(final String equation) {
        final int open = equation.indexOf('(');
        final int close = equation.indexOf(')');
        final double operand1 = Double.parseDouble(equation.substring(open+1,close));
        return Math.sin(operand1);
    }

    /**
     * Calculates the cosine of an angle given in the equation.
     * 
     * @param equation The equation containing the angle in parentheses, e.g. "cos(0.5)"
     * @return The cosine of the angle
     */
    public static double cosine(final String equation) {
        final int open = equation.indexOf('(');
        final int close = equation.indexOf(')');
        final double operand1 = Double.parseDouble(equation.substring(open+1,close));
        return Math.cos(operand1);
    }

    /**
     * Calculates the tangent of an angle given in the equation.
     * 
     * @param equation The equation containing the angle in parentheses, e.g. "tan(0.5)"
     * @return The tangent of the angle
     */
    public static double tangent(final String equation) {
        final int open = equation.indexOf('(');
        final int close = equation.indexOf(')');
        final double operand1 = Double.parseDouble(equation.substring(open+1,close));
        return Math.tan(operand1);
    }

    /**
     * Calculates the cosecant (reciprocal of sine) of an angle given in the equation.
     * 
     * @param equation The equation containing the angle in parentheses, e.g. "csc(0.5)"
     * @return The cosecant of the angle
     */
    public static double cosecant(final String equation) {
        final int open = equation.indexOf('(');
        final int close = equation.indexOf(')');
        final double operand1 = Double.parseDouble(equation.substring(open+1,close));
        return 1.0 / Math.sin(operand1);
    }

    /**
     * Calculates the secant (reciprocal of cosine) of an angle given in the equation.
     * 
     * @param equation The equation containing the angle in parentheses, e.g. "sec(0.5)"
     * @return The secant of the angle
     */
    public static double secant(final String equation) {
        final int open = equation.indexOf('(');
        final int close = equation.indexOf(')');
        final double operand1 = Double.parseDouble(equation.substring(open+1,close));
        return 1.0 / Math.cos(operand1);
    }

    /**
     * Calculates the cotangent (reciprocal of tangent) of an angle given in the equation.
     * 
     * @param equation The equation containing the angle in parentheses, e.g. "cot(0.5)"
     * @return The cotangent of the angle
     */
    public static double cotangent(final String equation) {
        final int open = equation.indexOf('(');
        final int close = equation.indexOf(')');
        final double operand1 = Double.parseDouble(equation.substring(open+1,close));
        return 1.0 / Math.tan(operand1);
    }
}
