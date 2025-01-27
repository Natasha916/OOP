package week1;
import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the quantity of items: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter the price per item: ");
        double pricePerItem = scanner.nextDouble();
        double totalCost = quantity * pricePerItem;
        System.out.println("The total cost is: " + totalCost);
        scanner.close();
    }
}