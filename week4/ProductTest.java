package week4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ProductTest {
    @Test
    public void testProductAssertions() {
        Product product = new Product("Laptop", 500.0, 2);

        assertAll("Product Properties",
            () -> assertNotNull(product.getName(), "Product name should not be null"),
            () -> assertTrue(product.getPrice() > 0, "Product price should be positive"),
            () -> assertTrue(product.isAffordable(1200.0), "Product should be affordable with budget 1200.0"),
            () -> assertFalse(product.isAffordable(900.0), "Product should not be affordable with budget 900.0")
        );
    }
}
