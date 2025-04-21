package dev.codedok;

import dev.codedok.operation.OperationFactory;
import dev.codedok.operation.MathOperation;

import java.util.Scanner;

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

        double lastValue = 0;
        OperationFactory factory = new OperationFactory();

        System.out.print("Enter a math problem: ");

        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println();
                Scanner scan = new Scanner(System.in);
                if (!scan.hasNext()) {
                    continue;
                }

                String fullEquation = scan.nextLine();

                if (fullEquation.isEmpty()) {
                    continue;
                }

                MathOperation operation = factory.getOperation(fullEquation);
                lastValue = operation.compute(fullEquation);

                System.out.print(lastValue);

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
