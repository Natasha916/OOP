package week4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FactorialTest {

    @Test
    public void testFactorialPositive() {
        Factorial factorial = new Factorial(); 
        assertEquals(120, factorial.calculateFactorial(5), "Factorial of 5 should be 120.");
    }

    @Test
    public void testFactorialZero() {
        Factorial factorial = new Factorial(); 
        assertEquals(1, factorial.calculateFactorial(0), "Factorial of 0 should be 1."); 
    }

    @Test
    public void testFactorialOne() {
        Factorial factorial = new Factorial(); 
        assertEquals(1, factorial.calculateFactorial(1), "Factorial of 1 should be 1.");
    }
}
