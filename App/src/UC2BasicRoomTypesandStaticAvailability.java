/**
 * UseCase2RoomInitialization demonstrates object modeling using inheritance 
 * and abstraction. It sets up the domain for different room types.
 * * @author Gemini
 * @version 2.0
 */

// 1. Abstract Class - Defines the "Template" for a Room
abstract class Room {
    private String roomType;
    private int beds;
    private double price;

    public Room(String roomType, int beds, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.price = price;
    }

    // Encapsulation: Using Getters to access private data
    public String getRoomType() { return roomType; }
    public int getBeds() { return beds; }
    public double getPrice() { return price; }

    // Abstract method: Every room MUST implement its own display logic
    public abstract void displayRoomDetails();
}

// 2. Concrete Classes - Inheritance in action
class SingleRoom extends Room {
    public SingleRoom() { super("Single Room", 1, 100.0); }

    @Override
    public void displayRoomDetails() {
        System.out.println(getRoomType() + " | Beds: " + getBeds() + " | Price: $" + getPrice());
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() { super("Double Room", 2, 180.0); }

    @Override
    public void displayRoomDetails() {
        System.out.println(getRoomType() + " | Beds: " + getBeds() + " | Price: $" + getPrice());
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() { super("Suite Room", 3, 350.0); }

    @Override
    public void displayRoomDetails() {
        System.out.println(getRoomType() + " | Beds: " + getBeds() + " | Price: $" + getPrice());
    }
}

// 3. Application Entry Point
public class UC2BasicRoomTypesandStaticAvailability {
    public static void main(String[] args) {
        // Welcome Message (Refactored from UC1)
        System.out.println("========================================");
        System.out.println("   Book My Stay App - Version 2.0");
        System.out.println("========================================");

        // Static Availability Representation (Simple variables as per requirements)
        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability = 2;

        // Polymorphism: Room references pointing to specific room objects
        Room single = new SingleRoom();
        Room totalDouble = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Display Room Information and Current State
        single.displayRoomDetails();
        System.out.println("   Available: " + singleRoomAvailability);

        totalDouble.displayRoomDetails();
        System.out.println("   Available: " + doubleRoomAvailability);

        suite.displayRoomDetails();
        System.out.println("   Available: " + suiteRoomAvailability);

        System.out.println("========================================");
    }
}