package week7;
public class HotelRoomArrayManager {

    // Generic method to print arrays of any type
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + "  ");
        }
        System.out.println(); // Move to next line
    }

    public static void main(String[] args) {

        // Array of room numbers (Integer)
        Integer[] roomNumbers = {101, 102, 103, 104};
        System.out.print("Room Numbers: ");
        printArray(roomNumbers);

        // Array of room types (String)
        String[] roomTypes = {"Deluxe", "Standard", "Suite", "Presidential"};
        System.out.print("Room Types: ");
        printArray(roomTypes);

        // Array of room prices (Double)
        Double[] roomPrices = {2500.50, 1800.00, 3200.75, 5000.00};
        System.out.print("Room Prices: ");
        printArray(roomPrices);
    }
}