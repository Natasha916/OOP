package week1;

public class Rectangle {
    double width;
    double height;
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public String toString() {
        return "Rectangle [Width: " + width + ", Height: " + height + "]";
    }

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(5.0, 10.0);
        Rectangle rectangle2 = new Rectangle(7.5, 3.5);
        System.out.println(rectangle1);
        System.out.println(rectangle2);
    }
}
