package week4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeNumberTest {

    @Test
    public void testPrimeNumberTrue() {
        PrimeNumber primeNumber = new PrimeNumber(); 
        assertTrue(primeNumber.isPrime(5), "5 should be identified as a prime number");
    }

    @Test
    public void testPrimeNumberFalse() {
        PrimeNumber primeNumber = new PrimeNumber(); 
        assertFalse(primeNumber.isPrime(4), "4 should not be identified as a prime number");
    }

    @Test
    public void testPrimeNumberEdgeCase() {
        PrimeNumber primeNumber = new PrimeNumber(); 
        assertFalse(primeNumber.isPrime(1), "1 should not be identified as a prime number");
    }
}
