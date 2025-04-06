package dev.codedok.strategy;

public class PiOperation implements OperationStrategy {
    @Override
    public double calculate(String equation) {
        return Math.PI;
    }
}
