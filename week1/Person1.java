package week1;

public class Person1 {
    String name;
    int age;
    String address;
    Person1(String name) {
        this.name = name;
        this.age = 0;  
        this.address = "Not Provided"; 
    }
    Person1(String name, int age) {
        this.name = name;
        this.age = age;
        this.address = "Not Provided";  
    }

    Person1(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println(); 
    }
}
