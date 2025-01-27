package week4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringManipulatorTest {

	@Test
	 void testStringManipulatorMethods() {
        StringManipulator manipulator = new StringManipulator();

        String input = "radar";
        String nonPalindrome = "hello";

        assertAll("StringManipulator Methods",
            () -> assertEquals("radar", manipulator.reverse(input), "Reverse method failed"),
            () -> assertEquals("olleh", manipulator.reverse(nonPalindrome), "Reverse method failed"),

            () -> assertEquals("RADAR", manipulator.toUpperCase(input), "toUpperCase method failed"),
            () -> assertEquals("HELLO", manipulator.toUpperCase(nonPalindrome), "toUpperCase method failed"),

            () -> assertTrue(manipulator.isPalindrome(input), "isPalindrome method failed"),
            () -> assertFalse(manipulator.isPalindrome(nonPalindrome), "isPalindrome method failed"),

            () -> assertEquals(2, manipulator.countVowels(input), "countVowels method failed"),
            () -> assertEquals(2, manipulator.countVowels(nonPalindrome), "countVowels method failed")
        );
    }

}
