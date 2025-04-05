package dev.codedok.operation;

/**
 * Abstract base class for all basic operations.
 * Implements the Template Method Pattern for parsing the equation.
 */
public abstract class BasicOperation implements Operation {
    protected String equation;
    protected double operand1;
    protected double operand2;
    
    /**
     * Constructor that sets the equation.
     * 
     * @param equation The equation to parse
     */
    public BasicOperation(String equation) {
        this.equation = equation;
        parseEquation();
    }
    
    /**
     * Template method to parse the equation.
     * This implements the Template Method Pattern.
     */
    protected void parseEquation() {
        int operatorIndex = findOperatorIndex();
        try {
            String operand1String = equation.substring(0, operatorIndex);
            String operand2String = equation.substring(operatorIndex + 1);
            
            if(operand1String.indexOf("-") != -1 && operand1String.startsWith("-")) {
                operand1 = -Double.parseDouble(operand1String.substring(1));
            } else {
                operand1 = Double.parseDouble(operand1String);
            }
            
            if(operand2String.indexOf("-") != -1 && operand2String.startsWith("-")) {
                operand2 = -Double.parseDouble(operand2String.substring(1));
            } else {
                operand2 = Double.parseDouble(operand2String);
            }
        } catch (Exception e) {
            operand1 = 0;
            operand2 = 0;
        }
    }
    
    /**
     * Each subclass must provide the index of its operator in the equation.
     * 
     * @return The index of the operator in the equation
     */
    protected abstract int findOperatorIndex();
} 