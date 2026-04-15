import java.util.HashMap;
import java.util.Map;

/**
 * UseCase3InventorySetup introduces centralized state management 
 * using a HashMap to track room availability.
 * * @author Gemini
 * @version 3.0
 */

// Domain Model (from Use Case 2)
abstract class RoomUC3 {
    private String roomType;
    private double price;

    public RoomUC3(String roomType, double price) {
        this.roomType = roomType;
        this.price = price;
    }

    public String getRoomType() { return roomType; }
    public double getPrice() { return price; }
}

class SingleRoomUC3 extends RoomUC3 { public SingleRoomUC3() { super("Single", 100.0); } }
class DoubleRoomUC3 extends RoomUC3 { public DoubleRoomUC3() { super("Double", 180.0); } }
class SuiteRoomUC3 extends RoomUC3 { public SuiteRoomUC3() { super("Suite", 350.0); } }

// --- NEW COMPONENT: Centralized Inventory Management ---
class RoomInventory {
    // HashMap acts as the Single Source of Truth
    // Key: Room Type (String), Value: Count (Integer)
    private Map<String, Integer> inventory = new HashMap<>();

    /**
     * Initializes the inventory with room types and their initial counts.
     */
    public void initializeRoom(String roomType, int count) {
        inventory.put(roomType, count);
    }

    /**
     * Retrieves current availability for a specific room type.
     * O(1) Time Complexity.
     */
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    /**
     * Updates the availability (e.g., after a booking or cancellation).
     */
    public void updateAvailability(String roomType, int newCount) {
        if (inventory.containsKey(roomType)) {
            inventory.put(roomType, newCount);
        }
    }

    /**
     * Prints the entire state of the inventory.
     */
    public void displayInventory() {
        System.out.println("Current Inventory Status:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue() + " rooms available");
        }
    }
}

// Application Entry Point
public class UC3CentralizedRoomInventoryManagement {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   Book My Stay App - Version 3.0");
        System.out.println("========================================");

        // 1. Initialize Inventory Component
        RoomInventory hotelInventory = new RoomInventory();

        // 2. Register Room Types (No more separate variables!)
        hotelInventory.initializeRoom("Single", 10);
        hotelInventory.initializeRoom("Double", 5);
        hotelInventory.initializeRoom("Suite", 2);

        // 3. Display Initial State
        hotelInventory.displayInventory();

        // 4. Demonstrate a Controlled Update (e.g., a booking happens)
        System.out.println("\n[System Update] One Single Room has been booked...");
        hotelInventory.updateAvailability("Single", 9);

        // 5. Retrieve and Display Updated State
        System.out.println("Updated Single Room Count: " + hotelInventory.getAvailability("Single"));

        System.out.println("========================================");
    }
}