package week4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ShapeTest {

 @Test
 public void testShapeArea() {
     Shape.ShapeBase shape = new Shape.ShapeBase(); 
     assertEquals(0, shape.area());
 }

 @Test
 public void testCircleArea() {
     Shape.Circle circle = new Shape.Circle(5); 
     assertEquals(Math.PI * 25, circle.area(), 0.01); 
 }

 @Test
 public void testRectangleArea() {
     Shape.Rectangle rectangle = new Shape.Rectangle(4, 5); 
     assertEquals(20, rectangle.area());
 }
}
