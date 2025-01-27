package week4;

public class Shape {

 public static class ShapeBase {
     public double area() {
         return 0; 
     }
 }

 public static class Circle extends ShapeBase {
     private double radius;

     public Circle(double radius) {
         this.radius = radius;
     }

     @Override
     public double area() {
         return Math.PI * radius * radius;
     }
 }

 public static class Rectangle extends ShapeBase {
     private double length;
     private double width;

     public Rectangle(double length, double width) {
         this.length = length;
         this.width = width;
     }

     @Override
     public double area() {
         return length * width;
     }
 }
}

