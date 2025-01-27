package Workshop2;

public class Dog extends Animal {
    String breed;

    Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    
    public void displayDetails() {
        System.out.println("Name: " + name + ", Breed: " + breed + ", Age: " + age);
    }
    public static void main(String[] args) {
        Dog dog = new Dog("Max", 9, "Labrador");
        dog.displayDetails();
    }
}