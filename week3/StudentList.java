package week3;

import java.io.*;
import java.util.*;

public class StudentList {

    public static List<Student> readStudentList(String fileName) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length != 4) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                try {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    char grade = parts[3].charAt(0);

                    students.add(new Student(id, name, age, grade));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid data in line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        return students;
    }

    public static void displayStudentsByGrade(List<Student> students) {
        students.sort(Comparator.comparing(Student::getGrade));

        System.out.println("List of students sorted by grade:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        String fileName = "students.csv";

        List<Student> students = readStudentList(fileName);

        displayStudentsByGrade(students);
    }
}
