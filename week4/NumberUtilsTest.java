package week4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberUtilsTest {

	@Test
    public void testGetEvenNumbers() {
        int[] input = {1, 2, 3, 4, 5, 6};
        int[] expectedOutput = {2, 4, 6};
        int[] result = NumberUtils.getEvenNumbers(input);
        assertArrayEquals(expectedOutput, result);
    }
}
