package week4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RectangleTest {

    @Test
    public void testArea() {
        Rectangle rectangle = new Rectangle(5, 4); 
        assertEquals(20, rectangle.area(), "The area should be 20 for a rectangle with length 5 and width 4.");
    }

    @Test
    public void testPerimeter() {
        Rectangle rectangle = new Rectangle(5, 4); 
        assertEquals(18, rectangle.perimeter(), "The perimeter should be 18 for a rectangle with length 5 and width 4.");
    }
}
