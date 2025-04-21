package dev.codedok.controller;

import static dev.codedok.controller.CalculatorController.mainLoop;

public class BasicCalculator {

    /*
     *  Known Issues:
     *  -Sigma doesn't work
     *  -The if-else if-else blocks need to be replaced with a switch block
     *  -Complex expressions are not yet supported
     *  -Custom variables are not yet supported
     */

    /*
     * Features to Add:
     * -Ability to store variables to a file (such as a .data in a "Calculator" Documents folder)
     * -GUI
     */
    public static void main(String[] args) {
        
        System.out.print("Enter a math problem: ");

        double result = 0.0;

        while(!Thread.currentThread().isInterrupted()) {
            result = mainLoop(result);
        }

    }


}