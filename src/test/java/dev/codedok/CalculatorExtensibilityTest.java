package dev.codedok;

import dev.codedok.operation.Operation;
import dev.codedok.operation.OperationRegistry;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Tests for the calculator using mocks to demonstrate
 * the advantages of the new architecture
 */
public class CalculatorExtensibilityTest {

    @Test
    public void testCustomOperationCanBeAdded() {
        // Create a custom operation
        Operation customOperation = new Operation() {
            @Override
            public double execute(String input) {
                return 42.0;
            }

            @Override
            public boolean canHandle(String input) {
                return "custom".equals(input);
            }
        };
        
        // Create a registry and add our custom operation
        OperationRegistry registry = new OperationRegistry();
        registry.register(customOperation);
        
        // Create a calculator with our registry
        Calculator calculator = new BasicCalculator(registry);
        
        // Verify our custom operation works
        double result = calculator.evaluate("custom");
        assertThat(result).isEqualTo(42.0);
    }
    
    @Test
    public void testCalculatorUsesRegistryCorrectly() {
        // Create mocks
        OperationRegistry mockRegistry = mock(OperationRegistry.class);
        Operation mockOperation = mock(Operation.class);
        
        // Setup mock behavior
        when(mockRegistry.findOperation("test")).thenReturn(mockOperation);
        when(mockOperation.execute("test")).thenReturn(99.0);
        
        // Create calculator with mock registry
        Calculator calculator = new BasicCalculator(mockRegistry);
        
        // Test the calculator
        double result = calculator.evaluate("test");
        
        // Verify interactions
        verify(mockRegistry).findOperation("test");
        verify(mockOperation).execute("test");
        assertThat(result).isEqualTo(99.0);
    }
}