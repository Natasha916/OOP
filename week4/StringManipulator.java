package week4;

public class StringManipulator {
	    public String reverse(String input) {
	        if (input == null) {
	            return null;
	        }
	        return new StringBuilder(input).reverse().toString();
	    }
	    public String toUpperCase(String input) {
	        if (input == null) {
	            return null;
	        }
	        return input.toUpperCase();
	    }
	    public boolean isPalindrome(String input) {
	        if (input == null) {
	            return false;
	        }
	        String reversed = reverse(input);
	        return input.equals(reversed);
	    }

	    public int countVowels(String input) {
	        if (input == null) {
	            return 0;
	        }
	        int count = 0;
	        String vowels = "aeiouAEIOU";
	        for (char c : input.toCharArray()) {
	            if (vowels.indexOf(c) != -1) {
	                count++;
	            }
	        }
	        return count;
	    }
	}

