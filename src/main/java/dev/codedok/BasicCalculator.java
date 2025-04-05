package dev.codedok;

import java.util.Scanner;

/**
 * Main calculator class that provides the command-line interface.
 * Follows the Single Responsibility Principle by separating the UI from the calculation logic.
 */
public class BasicCalculator {

    /*
     *  Known Issues:
     *  -Sigma doesn't work
     *  -Complex expressions are not yet supported
     *  -Custom variables are not yet supported
     */

    /*
     * Features to Add:
     * -Ability to store variables to a file (such as a .data in a "Calculator" Documents folder)
     * -GUI
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        System.out.print("Enter a math problem: ");
        
        Scanner scanner = new Scanner(System.in);
        
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println();
                
                if (!scanner.hasNext()) {
                    continue;
                }
                
                String equation = scanner.nextLine().trim();
                
                if (equation.isEmpty()) {
                    continue;
                }
                
                double result = calculator.calculate(equation);
                System.out.print(result);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // The following methods are kept for backward compatibility or reference
    
    public static double exponent(String equation) {
        int operator = equation.indexOf("^");
        String operand1String = equation.substring(0,operator);
        String operand2String = equation.substring(operator+1,equation.length());
        double operand1;
        double operand2;
        if(operand1String.indexOf("-") != -1) {
            operand1 = -Double.parseDouble(operand1String.substring(1,operand1String.length()));
        } else {
            operand1 = Double.parseDouble(operand1String.substring(0,operand1String.length()));
        }
        if(operand2String.indexOf("-") != -1) {
            operand2 = -Double.parseDouble(operand2String.substring(1,operand2String.length()));
        } else {
            operand2 = Double.parseDouble(operand2String.substring(0,operand2String.length()));
        }
        return Math.pow(operand1, operand2);
    }

    public static double multiplication(String equation) {
        int operator = equation.indexOf("*");
        double operand1 = Double.parseDouble(equation.substring(0,operator));
        double operand2 = Double.parseDouble(equation.substring(operator+1,equation.length()));
        return operand1 * operand2;
    }

    public static double division(String equation) {
        int operator = equation.indexOf("/");
        double operand1 = Double.parseDouble(equation.substring(0,operator));
        double operand2 = Double.parseDouble(equation.substring(operator+1,equation.length()));
        if(operand2 == 0) {
            return Double.NaN;
        } else {
            return operand1 / operand2;
        }
    }

    public static double addition(String equation) {
        int operator = equation.indexOf("+");
        double operand1 = Double.parseDouble(equation.substring(0,operator));
        double operand2 = Double.parseDouble(equation.substring(operator+1,equation.length()));
        return operand1 + operand2;
    }

    public static double subtraction (String equation) {
        int operator = equation.indexOf("-");
        double operand1 = Double.parseDouble(equation.substring(0,operator));
        double operand2 = Double.parseDouble(equation.substring(operator+1,equation.length()));
        return operand1 - operand2;
    }

    public static double mod(String equation) {
        int operator = equation.indexOf("%");
        double operand1 = Double.parseDouble(equation.substring(0,operator));
        double operand2 = Double.parseDouble(equation.substring(operator+1,equation.length()));
        if(operand2 == 0) {
            return Double.NaN;
        } else {
            return operand1 % operand2;
        }
    }

    public static double factoral(double n) {
        if(n==0)
            return 1;
        return n * factoral(n-1);
    }

    public static double sigma(long max, double n) {
        if(n == max)
            return n;
        return sigma(max, n+1);
    }
}