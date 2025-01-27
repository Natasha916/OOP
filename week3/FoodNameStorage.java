package week3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FoodNameStorage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "foods.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            System.out.println("Enter food names to store in the file. Type 'exit' to stop:");

            while (true) {
                System.out.print("Food name: ");
                String foodName = scanner.nextLine();

                if (foodName.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.write(foodName);
                writer.newLine();
                System.out.println("'" + foodName + "' has been added to the file.");
            }

            System.out.println("All food names have been saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}