// RoomChargeCalculator.java
package week7;
// Generic class with bounded type parameter T extends Number
class RoomCharge<T extends Number> {
    private T price;
    private T discount;

    public RoomCharge(T price, T discount) {
        this.price = price;
        this.discount = discount;
    }

    // Calculate total price (without discount)
    public double totalPrice() {
        return price.doubleValue(); // convert to double for calculations
    }

    // Calculate discounted price
    public double discountedPrice() {
        double discountAmount = price.doubleValue() * discount.doubleValue() / 100.0;
        return price.doubleValue() - discountAmount;
    }

    // Display method
    public void displayCharges() {
        System.out.println("Room Price: " + price);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Total Price: " + totalPrice());
        System.out.println("Discounted Price: " + discountedPrice());
        System.out.println("------------------------");
    }
}

// Main class
public class HotelBilling {
    public static void main(String[] args) {

        // Example 1: Using Integer
        RoomCharge<Integer> room1 = new RoomCharge<>(2500, 10); // price=2500, discount=10%
        room1.displayCharges();

        // Example 2: Using Double
        RoomCharge<Double> room2 = new RoomCharge<>(3200.75, 15.5); // price=3200.75, discount=15.5%
        room2.displayCharges();

        // Example 3: Using Float
        RoomCharge<Float> room3 = new RoomCharge<>(1800.50f, 5.0f); // price=1800.5, discount=5%
        room3.displayCharges();

        // The following would fail at compile-time:
        // RoomCharge<String> invalidRoom = new RoomCharge<>("2500", "10"); // Not allowed
    }
}