package week4;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private Map<String, Integer> inventory = new HashMap<>();

    public InventoryService() {
        inventory.put("Laptop", 10);
        inventory.put("Smartphone", 5);
        inventory.put("Headphones", 20);
    }

    public boolean isProductAvailable(String productName, int quantity) {
        if (inventory.containsKey(productName)) {
            int availableStock = inventory.get(productName);
            return availableStock >= quantity;
        }
        return false; 
    }

    public static void main(String[] args) {
        InventoryService service = new InventoryService();
        System.out.println(service.isProductAvailable("Laptop", 5)); 
        System.out.println(service.isProductAvailable("Smartphone", 6)); 
    }
}
