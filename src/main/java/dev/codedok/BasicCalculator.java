package dev.codedok;

import dev.codedok.strategy.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

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

        CalculatorContext context = new CalculatorContext();

        Map<String, OperationStrategy> operations = getOperations();

        double lastValue;

        System.out.print("Enter a math problem: ");

        while(!Thread.currentThread().isInterrupted()) {

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

                OperationStrategy strategy = operations.entrySet().stream()
                        .filter(entry -> fullEquation.contains(entry.getKey()))
                        .findFirst()
                        .map(Map.Entry::getValue)
                        .orElse(new CheckEquationOperation());

                context.setOperationStrategy(strategy);

                lastValue = context.executeOperationStrategy(fullEquation);

                System.out.print(lastValue);

            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }

    }

    public static Map<String, OperationStrategy> getOperations() {
        Map<String, OperationStrategy> operations = new LinkedHashMap<>();
        operations.put("^", new ExponentOperation());
        operations.put("*", new MultiplicationOperation());
        operations.put("/", new DivisionOperation());
        operations.put("%", new ModuloOperation());
        operations.put("+", new AdditionOperation());
        operations.put("-", new SubtractionOperation());
        operations.put("sin", new SineOperation());
        operations.put("cos", new CosineOperation());
        operations.put("tan", new TangentOperation());
        operations.put("csc", new CosecantOperation());
        operations.put("sec", new SecantOperation());
        operations.put("cot", new CotangentOperation());
        operations.put("pi", new PiOperation());
        operations.put("e", new EOperation());
        operations.put("!", new FactorialOperation());
        operations.put("E", new SigmaOperation());
        return operations;
    }
}