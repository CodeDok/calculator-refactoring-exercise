# Calculator Application

Original Source Code from https://github.com/brett-dun/Calculator/blob/master/src/BasicCalculator.java

## Project History

### Initial Changes
- Converted to maven project
- Add blackbox unit test
- Use interrupt instead of while true loop

### Refactoring With SOLID Principles and Design Patterns
This project has been refactored to improve code quality by applying SOLID principles and design patterns.

## SOLID Principles Applied

### Single Responsibility Principle (SRP)
- Each operation class has a single responsibility
- Separated input parsing, calculation logic, and user interface

### Open/Closed Principle (OCP)
- The `OperationRegistry` allows adding new operations without modifying existing code
- New operations can be added by implementing the `Operation` interface

### Liskov Substitution Principle (LSP)
- All operation types (unary, binary, trigonometric) can be used interchangeably where an `Operation` is expected
- The calculator works with any implementation of the `Operation` interface

### Interface Segregation Principle (ISP)
- Clean, focused interfaces with only the methods they need
- Different operation types extend appropriate base classes

### Dependency Inversion Principle (DIP)
- High-level modules depend on abstractions, not concrete implementations
- `BasicCalculator` depends on the `Calculator` interface and `Operation` interface

## Design Patterns Used

### Strategy Pattern
- Each operation is a strategy for handling different types of calculations
- The `OperationRegistry` selects the appropriate strategy based on the input

### Factory Method Pattern
- The `OperationRegistry` acts as a factory for creating/providing the appropriate operation

### Template Method Pattern
- Abstract operation classes define the template for operations
- Concrete operation classes implement only the parts that vary

## Benefits of the Refactoring

1. **Extensibility**: Easy to add new operations without changing existing code
2. **Maintainability**: Single responsibility classes are easier to understand and modify
3. **Testability**: Components can be tested in isolation with mocks
4. **Reduced Duplication**: Common code is shared in base classes
5. **Cleaner Code**: Removed lengthy if-else chains and redundant code

## How to Run

```bash
mvn clean install
java -jar target/Calc-1.0-SNAPSHOT.jar
```

## How to Add a New Operation

To add a new operation:

1. Create a new class implementing `Operation` interface
2. Register it in the `OperationRegistry`
3. No changes to the calculator logic are needed