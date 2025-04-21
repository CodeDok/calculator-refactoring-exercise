package dev.codedok.operation;

import java.util.ArrayList;
import java.util.List;

public class OperationFactory {
    private final List<MathOperation> operations = new ArrayList<>();

    public OperationFactory() {
        operations.add(new AdditionOperation());
        operations.add(new SubtractionOperation());
        operations.add(new MultiplicationOperation());
        operations.add(new DivisionOperation());
        operations.add(new ModuloOperation());
        operations.add(new ExponentOperation());
        operations.add(new FactorialOperation());
        operations.add(new TrigOperation());
        operations.add(new ConstantOperation());
        operations.add(new NumberOperation());
        operations.add(new InvalidOperation());
    }

    public MathOperation getOperation(String input) {
        for (MathOperation op : operations) {
            if (op.matches(input)) {
                return op;
            }
        }
        return new InvalidOperation();
    }
}
