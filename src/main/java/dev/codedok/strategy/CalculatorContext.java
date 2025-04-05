package dev.codedok.strategy;

public class CalculatorContext {
    private OperationStrategy strategy;

    public void setOperationStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeOperationStrategy(String equation) {
        return strategy.calculate(equation);
    }
}
