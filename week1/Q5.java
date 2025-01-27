package week1;
import java.util.Scanner;
public class Q5 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of one side of the square: ");
        double side = scanner.nextDouble(); 
        double area = side * side;
        System.out.printf("The area of the square is: %.2f\n", area);
        scanner.close();
    }
}
