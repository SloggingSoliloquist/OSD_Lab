package week7;
class Room<T, U> {
    private T roomId;   // Room number or ID
    private U roomAttr; // Room type or price

    // Constructor
    public Room(T roomId, U roomAttr) {
        this.roomId = roomId;
        this.roomAttr = roomAttr;
    }

    // Getter for Room ID
    public T getRoomId() {
        return roomId;
    }

    // Getter for Room Attribute
    public U getRoomAttr() {
        return roomAttr;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Room ID: " + roomId + ", Room Info: " + roomAttr);
    }
}

// Main class to demonstrate usage
public class HotelDemo {
    public static void main(String[] args) {

        // Example 1: Room ID as Integer, Room Type as String
        Room<Integer, String> room1 = new Room<>(101, "Deluxe");
        room1.displayInfo();

        // Example 2: Room ID as String, Price as Double
        Room<String, Double> room2 = new Room<>("A-202", 2500.50);
        room2.displayInfo();

        // Example 3: Room ID as Integer, Price as Double
        Room<Integer, Double> room3 = new Room<>(303, 3200.75);
        room3.displayInfo();

        // Example 4: Room ID as String, Room Type as String
        Room<String, String> room4 = new Room<>("Suite-1", "Presidential Suite");
        room4.displayInfo();
    }
}