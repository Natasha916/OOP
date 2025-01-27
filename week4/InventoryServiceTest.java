package week4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InventoryServiceTest {

    @Test
    public void testProductAvailable() {
        InventoryService service = new InventoryService();
        assertTrue(service.isProductAvailable("Laptop", 5), "Laptop should be available with quantity 5");
    }

    @Test
    public void testProductNotAvailableDueToQuantity() {
        InventoryService service = new InventoryService();
        assertFalse(service.isProductAvailable("Smartphone", 6), "Smartphone should not be available with quantity 6");
    }

    @Test
    public void testProductNotFound() {
        InventoryService service = new InventoryService();
        assertFalse(service.isProductAvailable("Tablet", 1), "Tablet should not be available as it is not in inventory");
    }
}
