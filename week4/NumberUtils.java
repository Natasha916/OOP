package week4;

import java.util.ArrayList;

public class NumberUtils {
	public static int[] getEvenNumbers(int[] numbers) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            int number = 0;
			if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        int[] result = new int[evenNumbers.size()];
        for (int i = 0; i < evenNumbers.size(); i++) {
            result[i] = evenNumbers.get(i);
        }
        return result;
    }

}
