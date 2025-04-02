package dev.codedok;

import java.util.ArrayList;
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
    public static void main(String args[]) {

        ArrayList<Variable> variables = new ArrayList<Variable>();

        double lastValue = 0;

        System.out.print("Enter a math problem: ");

        while(true) {

            try {

                System.out.println();
                Scanner scan = new Scanner(System.in);
                String fullEquation = scan.next();
                String[] equation;

                if(fullEquation.indexOf("^") != -1) {
                    lastValue = exponent(fullEquation);

                }

                //Multiplication,Division,Modulo Division
                else if(fullEquation.indexOf("*") != -1) {
                    lastValue = multiplication(fullEquation);

                } else if(fullEquation.indexOf("/") != -1) {
                    lastValue = division(fullEquation);

                } else if(fullEquation.indexOf("%") != -1) {
                    lastValue = mod(fullEquation);

                }

                //Addition & Subtraction
                else if(fullEquation.indexOf("+") != -1) {
                    lastValue = addition(fullEquation);

                } else if(fullEquation.indexOf("-") != -1) {
                    lastValue = subtraction(fullEquation);

                }


                //Trig Functions
                else if(fullEquation.indexOf("sin") != -1) {
                    lastValue = TrigFunctions.sine(fullEquation);

                } else if(fullEquation.indexOf("cos") != -1) {
                    lastValue = TrigFunctions.cosine(fullEquation);

                } else if(fullEquation.indexOf("tan") != -1) {
                    lastValue = TrigFunctions.tangent(fullEquation);

                } else if(fullEquation.indexOf("csc") != -1) {
                    lastValue = TrigFunctions.cosecant(fullEquation);

                } else if(fullEquation.indexOf("sec") != -1) {
                    lastValue = TrigFunctions.secant(fullEquation);

                } else if(fullEquation.indexOf("cot") != -1) {
                    lastValue = TrigFunctions.cotangent(fullEquation);

                }

                //Constants
                else if(fullEquation.indexOf("pi") != -1) {
                    lastValue = Constants.pi();

                } else if(fullEquation.indexOf("e") != -1) {
                    lastValue = Constants.e();

                }


                //Advanced Operators
                else if(fullEquation.indexOf("!") != -1) {
                    int operator = fullEquation.indexOf("!");
                    long operand1 = (long) Double.parseDouble(fullEquation.substring(0,operator));
                    lastValue = factoral(operand1);

                } else if(fullEquation.indexOf("E") != -1) {
                    int start = fullEquation.indexOf("(");
                    System.out.println(start);
                    int operator2 = fullEquation.indexOf(",");
                    System.out.println(operator2);
                    int end = fullEquation.indexOf(")");
                    System.out.println(end);
                    long operand1 = (long) Double.parseDouble(fullEquation.substring(start+1,operator2));
                    double operand2 = (long) Double.parseDouble(fullEquation.substring(operator2+1,end));
                    //lastValue = sigma(operand1,operand2);

                } else {
                    try {
                        lastValue = Double.parseDouble(fullEquation);
                    } catch (Exception e) {
                        lastValue = Double.NaN;
                    }
                }

                System.out.print(lastValue);

            } catch (Exception e1) {
                e1.printStackTrace();
            }


        }

    }


    public static double exponent(String equation) {

        //Lots of work will be needed in order to support negative exponents

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