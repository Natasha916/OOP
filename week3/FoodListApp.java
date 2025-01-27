package week3;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FoodListApp {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = "foods.txt";

        FileWriter writer = new FileWriter(fileName, true);
            System.out.println("Enter food names (type 'done' to finish):");

            while (true) {
                System.out.print("Food: ");
                String food = scanner.nextLine();

                if (food.equalsIgnoreCase("done")) {
                    break;
                }

                writer.write(food + "\n");
            }

            System.out.println("Food names have been saved to " + fileName);
     
    }
}
