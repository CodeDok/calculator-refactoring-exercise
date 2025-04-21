package dev.codedok;

import dev.codedok.controller.BasicCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        if (calculatorThread != null && calculatorThread.isAlive()) {
            calculatorThread.interrupt();
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
        // Give the calculator time to start
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private String getFirstOutputLineFromOut() {
        return outContent.toString().split("\\R")[1];
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
        calculateAndAssert(input, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "sin(0), 0.0",
            "cos(0), 1.0",
            "tan(0), 0.0"
    })
    public void testTrigonometricFunctions(String input, String expected) {
        calculateAndAssert(input, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "pi, 3.141592653589793",
            "e, 2.718281828459045"
    })
    public void testConstants(String input, String expected) {
        calculateAndAssert(input, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "0!, 1.0",
            "5!, 120.0"
    })
    public void testFactorial(String input, String expected) {
        calculateAndAssert(input, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "5%0, NaN",
            "5/0, NaN",
            "invalid, NaN"
    })
    public void testNanCases(String input, String expected) {
        calculateAndAssert(input, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "-5+3, -2.0",
            "-2*-3, 6.0"
    })
    public void testNegativeNumbers(String input, String expected) {
        calculateAndAssert(input, expected);
    }

    private void calculateAndAssert(String input, String expected) {
        provideInput(input);
        startCalculator();
        assertThat(getFirstOutputLineFromOut()).isEqualToIgnoringNewLines(expected);
    }
} 