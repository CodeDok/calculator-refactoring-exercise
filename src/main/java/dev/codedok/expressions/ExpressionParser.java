package dev.codedok.expressions;

import dev.codedok.expressions.base.*;
import dev.codedok.expressions.operators.*;
import dev.codedok.expressions.functions.*;
import dev.codedok.expressions.constants.*;

public class ExpressionParser {
    public static Expression parse(String input) {
        input = input.trim();

        // constants / values
        if (input.matches("-?\\d+(\\.\\d+)?")) { 
            return new Value(Double.parseDouble(input));
        } else if (input.equalsIgnoreCase(Pi.SYMBOL)) {
            return new Pi();
        } else if (input.equalsIgnoreCase(Euler.SYMBOL)) {
            return new Euler();
        }

        String[] ops = { "^", "*", "/", "%", "+", "-" };
        for (String op : ops) {
            String[] parts = splitExpression(input, op);
            if (parts != null) {
                Expression left = parse(parts[0].trim());
                Expression right = parse(parts[1].trim());
                switch (op) {
                    case "^": return new Exponent(left, right);
                    case "*": return new Multiplication(left, right);
                    case "/": return new Division(left, right);
                    case "%": return new Modulo(left, right);
                    case "+": return new Addition(left, right);
                    case "-": return new Subtraction(left, right);
                }
            }
        }

        // factorial
        if (input.endsWith("!")) {
            Expression operand = parse(input.substring(0, input.length() - 1).trim());
            return new Factorial(operand);
        }

        // functions
        if (input.startsWith("sin(") && input.endsWith(")")) {
            return new Sine(parse(input.substring(4, input.length() - 1).trim()));
        } else if (input.startsWith("cos(") && input.endsWith(")")) {
            return new Cosine(parse(input.substring(4, input.length() - 1).trim()));
        } else if (input.startsWith("tan(") && input.endsWith(")")) {
            return new Tangent(parse(input.substring(4, input.length() - 1).trim()));
        } else if (input.startsWith("cot(") && input.endsWith(")")) {
            return new Cotangent(parse(input.substring(4, input.length() - 1).trim()));
        } else if (input.startsWith("sec(") && input.endsWith(")")) {
            return new Secant(parse(input.substring(4, input.length() - 1).trim()));
        } else if (input.startsWith("csc(") && input.endsWith(")")) {
            return new Cosecant(parse(input.substring(4, input.length() - 1).trim()));
        }

        throw new IllegalArgumentException("Invalid expression: " + input);
    }

     // splits operations on the specified operator (works with parentheses)
    private static String[] splitExpression(String input, String operator) {
        int depth = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (c == ')') {
                depth++;
            } else if (c == '(') {
                depth--;
            } else if (depth == 0 && input.startsWith(operator, i)) {
                if (operator.equals("-") && i == 0) continue;

                String left = input.substring(0, i);
                String right = input.substring(i + operator.length());
                return new String[] { left, right };
            }
        }
        return null;
    }
}