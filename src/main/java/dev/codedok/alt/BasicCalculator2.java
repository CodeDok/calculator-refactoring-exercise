//package dev.codedok;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.function.Function;
//
//import dev.codedok.util.AdvancedOperations;
//import dev.codedok.util.Constants;
//import dev.codedok.util.SimpleOperations;
//import dev.codedok.util.TrigFunctions;
//
//public class BasicCalculator {
//
//    /*
//     *  Known Issues:
//     *  -Sigma doesn't work
//     *  -The if-else if-else blocks need to be replaced with a switch block
//     *  -Complex expressions are not yet supported
//     *  -Custom variables are not yet supported
//     */
//
//    /*
//     * Features to Add:
//     * -Ability to store variables to a file (such as a .data in a "Calculator" Documents folder)
//     * -GUI
//     */
//
//    public static void main(String[] args) {
//
//
//        Map<String, Function<String, Double>> operations = getOperations();
//
//        double lastValue;
//
//        System.out.print("Enter a math problem: ");
//
//        while(!Thread.currentThread().isInterrupted()) {
//
//            try {
//                System.out.println();
//                Scanner scan = new Scanner(System.in);
//                if (!scan.hasNext()) {
//                    continue;
//                }
//
//                String fullEquation = scan.nextLine();
//
//                if (fullEquation.isEmpty()) {
//                    continue;
//                }
//
//               lastValue = operations.entrySet().stream()
//                        .filter(entry -> fullEquation.contains(entry.getKey()))
//                        .findFirst()
//                        .map(entry -> entry.getValue().apply(fullEquation))
//                        .orElse(checkEquation(fullEquation));
//
//                System.out.print(lastValue);
//
//            } catch (RuntimeException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//
//    }
//
//    public static Map<String, Function<String, Double>> getOperations() {
//        Map<String, Function<String, Double>> handlers = new HashMap<>();
//        handlers.put("+", SimpleOperations::addition);
//        handlers.put("-", SimpleOperations::subtraction);
//        handlers.put("*", SimpleOperations::multiplication);
//        handlers.put("/", SimpleOperations::division);
//        handlers.put("%", AdvancedOperations::mod);
//        handlers.put("^", AdvancedOperations::exponent);
//        handlers.put("!", AdvancedOperations::factorial);
//        handlers.put("E", AdvancedOperations::sigma);
//        handlers.put("pi", Constants::pi);
//        handlers.put("e", Constants::e);
//        handlers.put("sin", TrigFunctions::sine);
//        handlers.put("cos", TrigFunctions::cosine);
//        handlers.put("tan", TrigFunctions::tangent);
//        handlers.put("csc", TrigFunctions::cosecant);
//        handlers.put("sec", TrigFunctions::secant);
//        handlers.put("cot", TrigFunctions::cotangent);
//        return handlers;
//    }
//
//    public static double checkEquation(String equation) {
//        try {
//            return Double.parseDouble(equation);
//        } catch (Exception e) {
//            return Double.NaN;
//        }
//    }
//
//}