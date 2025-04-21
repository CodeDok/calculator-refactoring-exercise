package dev.codedok;

import java.util.Scanner;

import dev.codedok.expressions.ExpressionParser;

public class BasicCalculator {

    /*
     * Known Issues:
     * -Sigma doesn't work
     * -The if-else if-else blocks need to be replaced with a switch block
     * -Complex expressions are not yet supported
     * -Custom variables are not yet supported
     */

    /*
     * Features to Add:
     * -Ability to store variables to a file (such as a .data in a "Calculator"
     * Documents folder)
     * -GUI
     */

    public static void main(String[] args) {
        System.out.println("Enter a math problem: ");

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                String fullEquation = scanner.next();
                if (fullEquation.isEmpty()) {
                    continue;
                }

                try {
                    var expression = ExpressionParser.parse(fullEquation);
                    System.out.println(expression.evaluate());
                } catch (Exception e1) {
                    System.out.println("NaN");
                }

            } while (!Thread.currentThread().isInterrupted());
        }
    }
}