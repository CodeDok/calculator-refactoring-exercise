package dev.codedok.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static dev.codedok.operations.BinaryOperations.*;
import static dev.codedok.operations.TrigFunctions.*;
import static dev.codedok.operations.UnitaryOperations.factorial;
import static dev.codedok.operations.UnitaryOperations.strangeOperation;

public class CalculatorController {

    public static final List<String> SUPPORTED_OPERATORS = List.of(
            "^", "*", "/", "%", "+", "-", "sin", "cos", "tan", "csc", "sec", "cot", "pi", "e", "!", "E");

    static double mainLoop(double result) {
        try {
            System.out.println();
            String fullEquation = receiveEquationFromStdIn();
            if (fullEquation == null) return result;

            Optional<String> operatorOpt = SUPPORTED_OPERATORS.stream().filter(fullEquation::contains).findFirst();

            if (operatorOpt.isEmpty()) {
                result = parseDoubleOrNan(fullEquation);
                System.out.println(result);
                return result;
            }

            result = calculateResult(operatorOpt.get(), fullEquation, result);
            System.out.print(result);

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return result;
    }

    private static double parseDoubleOrNan(String fullEquation) {
        try {
            return Double.parseDouble(fullEquation);
        } catch (NullPointerException | NumberFormatException e) {
            return Double.NaN;
        }
    }

    private static double calculateResult(String operator, String fullEquation, double previousResult) {

        return switch (operator) {
            case "^" -> exponent(fullEquation);

            case "*" -> multiplication(fullEquation);
            case "/" -> division(fullEquation);
            case "%" -> mod(fullEquation);

            case "+" -> addition(fullEquation);
            case "-" -> subtraction(fullEquation);

            case "sin" -> sine(fullEquation);
            case "cos" -> cosine(fullEquation);
            case "tan" -> tangent(fullEquation);
            case "csc" -> cosecant(fullEquation);
            case "sec" -> secant(fullEquation);
            case "cot" -> cotangent(fullEquation);

            case "pi" -> Math.PI;
            case "e" -> Math.E;

            case "!" -> factorial(fullEquation);
            case "E" -> {
                strangeOperation(fullEquation);
                yield previousResult;
            }

            default -> parseDoubleOrNan(fullEquation);
        };
    }

    private static String receiveEquationFromStdIn() {
        Scanner scan = new Scanner(System.in);
        if (!scan.hasNext()) {
            return null;
        }

        String fullEquation = scan.nextLine();

        if (fullEquation.isEmpty()) {
            return null;
        }
        return fullEquation;
    }
}
