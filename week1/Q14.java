package week1;
import java.util.Scanner;

public class Q14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount in U.S. dollars: ");
        double dollars = scanner.nextDouble();
        System.out.print("Enter the exchange rate to the target currency: ");
        double exchangeRate = scanner.nextDouble();
        double convertedAmount = dollars * exchangeRate;
        System.out.println("The converted amount is: " + convertedAmount);
        scanner.close();
        
    }
}
