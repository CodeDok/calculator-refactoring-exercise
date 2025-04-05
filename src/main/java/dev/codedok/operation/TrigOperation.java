package dev.codedok.operation;

/**
 * Abstract base class for all trigonometric operations.
 * Implements the Template Method Pattern for parsing the equation.
 */
public abstract class TrigOperation implements Operation {
    protected String equation;
    protected double operand;
    protected String functionName;
    
    /**
     * Constructor that sets the equation and function name.
     * 
     * @param equation The equation to parse
     * @param functionName The name of the trigonometric function
     */
    public TrigOperation(String equation, String functionName) {
        this.equation = equation;
        this.functionName = functionName;
        parseEquation();
    }
    
    /**
     * Template method to parse the equation.
     * This implements the Template Method Pattern.
     */
    protected void parseEquation() {
        try {
            int open = equation.indexOf("(");
            int close = equation.indexOf(")");
            String operandStr = equation.substring(open + 1, close);
            operand = Double.parseDouble(operandStr);
        } catch (Exception e) {
            operand = 0;
        }
    }
    
    @Override
    public boolean canHandle(String equation) {
        return equation.indexOf(functionName) != -1;
    }
} 