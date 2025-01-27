package week4;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	    @Test
	    public void testAdd() {
	        Calculator calculator = new Calculator();
	        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
	        assertEquals(-5, calculator.add(-2, -3), "-2 + -3 should equal -5");
	       
	    }
	}


