package dev.codedok;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicCalculatorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private ByteArrayInputStream inContent;
    private Thread calculatorThread;
    
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        calculator = new BasicCalculator();
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        if (calculatorThread != null && calculatorThread.isAlive()) {
            calculatorThread.interrupt();
            try {
                calculatorThread.join(500); // Wait for thread to terminate
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void provideInput(String input) {
        String inputWithNewLine = input + "\n";
        inContent = new ByteArrayInputStream(inputWithNewLine.getBytes());
        System.setIn(inContent);
    }

    private void startCalculator() {
        calculatorThread = new Thread(() -> {
            try {
                BasicCalculator.main(new String[]{});
            } catch (Exception e) {
                // Expected when we interrupt the thread
            }
        });
        calculatorThread.start();
        // Give the calculator time to start and process input
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private String getFirstOutputLineFromOut() {
        String output = outContent.toString();
        // Get the output after the prompt
        String[] lines = output.split("\\R");
        // The first line is the prompt, the output is after that
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("Enter a math problem:")) {
                // Return the next non-empty line after the prompt
                for (int j = i + 1; j < lines.length; j++) {
                    if (!lines[j].trim().isEmpty()) {
                        return lines[j].trim();
                    }
                }
            }
        }
        // If we can't find the expected pattern, return the last line
        return lines.length > 0 ? lines[lines.length - 1].trim() : "";
    }
    
    @Test
    public void testCalculatorDirectly() {
        assertThat(calculator.evaluate("2+3")).isEqualTo(5.0);
        assertThat(calculator.evaluate("5-3")).isEqualTo(2.0);
        assertThat(calculator.evaluate("4*3")).isEqualTo(12.0);
    }

    @ParameterizedTest
    @CsvSource({
            "2+3, 5.0",
            "5-3, 2.0",
            "4*3, 12.0",
            "6/2, 3.0",
            "5%2, 1.0"
    })
    public void testBasicOperations(String input, String expected) {
        calculateAndAssert(input, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "2^3, 8.0",
            "2^-3, 0.125"
    })
    public void testExponentiation(String input, String expected) {
        double result = calculator.evaluate(input);
        double expectedValue = Double.parseDouble(expected);
        assertThat(result).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
            "sin(0), 0.0",
            "cos(0), 1.0",
            "tan(0), 0.0"
    })
    public void testTrigonometricFunctions(String input, String expected) {
        double result = calculator.evaluate(input);
        double expectedValue = Double.parseDouble(expected);
        assertThat(result).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
            "pi, 3.141592653589793",
            "e, 2.718281828459045"
    })
    public void testConstants(String input, String expected) {
        double result = calculator.evaluate(input);
        double expectedValue = Double.parseDouble(expected);
        assertThat(result).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
            "0!, 1.0",
            "5!, 120.0"
    })
    public void testFactorial(String input, String expected) {
        double result = calculator.evaluate(input);
        double expectedValue = Double.parseDouble(expected);
        assertThat(result).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
            "5%0, NaN",
            "5/0, NaN",
            "invalid, NaN"
    })
    public void testNanCases(String input, String expected) {
        double result = calculator.evaluate(input);
        if ("NaN".equals(expected)) {
            assertThat(result).isNaN();
        } else {
            double expectedValue = Double.parseDouble(expected);
            assertThat(result).isEqualTo(expectedValue);
        }
    }

    @ParameterizedTest
    @CsvSource({
            "-5+3, -2.0",
            "-2*-3, 6.0"
    })
    public void testNegativeNumbers(String input, String expected) {
        double result = calculator.evaluate(input);
        double expectedValue = Double.parseDouble(expected);
        assertThat(result).isEqualTo(expectedValue);
    }

    private void calculateAndAssert(String input, String expected) {
        // Test using the direct API first
        double result = calculator.evaluate(input);
        if ("NaN".equals(expected)) {
            assertThat(result).isNaN();
        } else {
            double expectedValue = Double.parseDouble(expected);
            assertThat(result).isEqualTo(expectedValue);
        }
        
        // Also test via the command line interface if needed
        provideInput(input);
        startCalculator();
        String output = getFirstOutputLineFromOut();
        if (!output.isEmpty()) {
            assertThat(output).isEqualToIgnoringNewLines(expected);
        }
    }
}