package dev.codedok;

/**
 * Mathematical constants used throughout the calculator.
 * This class provides commonly used constants like PI and E.
 */
public final class Constants {
    
    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private Constants() {
        // Utility class should not be instantiated
    }

    /**
     * Returns the value of PI (π).
     * 
     * @return The mathematical constant PI (3.14159...)
     */
    public static double getPi() {
        return Math.PI;
    }

    /**
     * Returns the value of Euler's number (e).
     * 
     * @return The mathematical constant e (2.71828...)
     */
    public static double getE() {
        return Math.E;
    }
}