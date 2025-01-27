package week1;
import java.util.Scanner;
public class Q8{
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the principle amount: ");
	        double radius = scanner.nextDouble(); 
	        System.out.print("Enter the rate of interest: ");
	        double time = scanner.nextDouble(); 
	        System.out.print("Enter the time period: ");
	        double height = scanner.nextDouble(); 
	        double volume = Math.PI * Math.pow(radius, 2) * height;
	        System.out.printf("The volume of the cylinder is: ",+ volume);
	        scanner.close();
	    }
}