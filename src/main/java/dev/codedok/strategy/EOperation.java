package dev.codedok.strategy;

public class EOperation implements OperationStrategy {
    @Override
    public double calculate(String equation) {
        return Math.E;
    }
}
