package dev.codedok;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

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
        inContent = new ByteArrayInputStream(input.getBytes());
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

    @Test
    public void testBasicOperations() {
        // Test addition
        provideInput("2+3\n");
        startCalculator();
        assertTrue(outContent.toString().contains("5.0"));

        // Test subtraction
        provideInput("5-3\n");
        startCalculator();
        assertTrue(outContent.toString().contains("2.0"));

        // Test multiplication
        provideInput("4*3\n");
        startCalculator();
        assertTrue(outContent.toString().contains("12.0"));

        // Test division
        provideInput("6/2\n");
        startCalculator();
        assertTrue(outContent.toString().contains("3.0"));

        // Test modulo
        provideInput("5%2\n");
        startCalculator();
        assertTrue(outContent.toString().contains("1.0"));
    }

    @Test
    public void testExponentiation() {
        provideInput("2^3\n");
        startCalculator();
        assertTrue(outContent.toString().contains("8.0"));

        provideInput("2^-2\n");
        startCalculator();
        assertTrue(outContent.toString().contains("0.25"));
    }

    @Test
    public void testTrigonometricFunctions() {
        // Test sine
        provideInput("sin(0)\n");
        startCalculator();
        assertTrue(outContent.toString().contains("0.0"));

        // Test cosine
        provideInput("cos(0)\n");
        startCalculator();
        assertTrue(outContent.toString().contains("1.0"));

        // Test tangent
        provideInput("tan(0)\n");
        startCalculator();
        assertTrue(outContent.toString().contains("0.0"));
    }

    @Test
    public void testConstants() {
        // Test pi
        provideInput("pi\n");
        startCalculator();
        assertTrue(outContent.toString().contains("3.141592653589793"));

        // Test e
        provideInput("e\n");
        startCalculator();
        assertTrue(outContent.toString().contains("2.718281828459045"));
    }

    @Test
    public void testFactorial() {
        provideInput("5!\n");
        startCalculator();
        assertTrue(outContent.toString().contains("120.0"));

        provideInput("0!\n");
        startCalculator();
        assertTrue(outContent.toString().contains("1.0"));
    }

    @Test
    public void testDivisionByZero() {
        provideInput("5/0\n");
        startCalculator();
        assertTrue(outContent.toString().contains("NaN"));
    }

    @Test
    public void testModuloByZero() {
        provideInput("5%0\n");
        startCalculator();
        assertTrue(outContent.toString().contains("NaN"));
    }

    @Test
    public void testInvalidInput() {
        provideInput("invalid\n");
        startCalculator();
        assertTrue(outContent.toString().contains("NaN"));
    }

    @Test
    public void testNegativeNumbers() {
        provideInput("-5+3\n");
        startCalculator();
        assertTrue(outContent.toString().contains("-2.0"));

        provideInput("-2*-3\n");
        startCalculator();
        assertTrue(outContent.toString().contains("6.0"));
    }
} 