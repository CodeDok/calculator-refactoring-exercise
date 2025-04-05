package dev.codedok.operation;

/**
 * Constant operation implementation.
 * Follows the Single Responsibility Principle by only handling mathematical constants.
 */
public class ConstantOperation implements Operation {
    private final String equation;
    private final String constantName;
    
    public ConstantOperation(String equation, String constantName) {
        this.equation = equation;
        this.constantName = constantName;
    }
    
    @Override
    public double execute() {
        if ("pi".equals(constantName)) {
            return Math.PI;
        } else if ("e".equals(constantName)) {
            return Math.E;
        }
        try {
            return Double.parseDouble(equation);
        } catch (Exception e) {
            return Double.NaN;
        }
    }
    
    @Override
    public boolean canHandle(String equation) {
        return equation.equals(constantName) ||
               equation.indexOf(constantName) != -1 ||
               isNumeric(equation);
    }
    
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Factory method to create an instance if this operation can handle the equation.
     * This implements the Factory Method Pattern.
     * 
     * @param equation The equation to check
     * @return A new instance if applicable, null otherwise
     */
    public static ConstantOperation createIfApplicable(String equation) {
        if (equation.indexOf("pi") != -1) {
            return new ConstantOperation(equation, "pi");
        } else if (equation.indexOf("e") != -1) {
            return new ConstantOperation(equation, "e");
        }
        try {
            Double.parseDouble(equation);
            return new ConstantOperation(equation, "number");
        } catch (Exception e) {
            return null;
        }
    }
} 