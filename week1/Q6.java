package week1;
import java.util.Scanner;
public class Q6 {
	public class CelsiusToFahrenheit {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the temperature in Celsius: ");
	        double celsius = scanner.nextDouble();
	        double fahrenheit = (celsius * 9/5) + 32;
	        System.out.printf("The temperature in Fahrenheit is: %.2f\n", fahrenheit);
	        scanner.close();
	    }
	}
}
