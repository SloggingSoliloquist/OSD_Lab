class Hotel {
    private int availableRooms;

    public Hotel(int totalRooms) {
        this.availableRooms = totalRooms;
    }

    // Book a room
    public synchronized void bookRoom(String customerName) {
        while (availableRooms == 0) {
            try {
                System.out.println(customerName + " waiting for a room");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        availableRooms--;
        System.out.println(customerName + " booked a room. Rooms left: " + availableRooms);
    }

    // Release a room
    public synchronized void releaseRoom(String customerName) {
        availableRooms++;
        System.out.println(customerName + " released a room. Rooms left: " + availableRooms);
        notifyAll();
    }
}

class Customer extends Thread {
    private final Hotel hotel;

    public Customer(String name, Hotel hotel) {
        super(name);
        this.hotel = hotel;
    }

    @Override
    public void run() {
        hotel.bookRoom(getName());

        try {
            Thread.sleep(3000); // customer stays in the room
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        hotel.releaseRoom(getName());
    }
}

public class lab4_q1 {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(3); // hotel with 3 rooms

        for (int i = 1; i <= 6; i++) {
            new Customer("Customer-" + i, hotel).start();
        }
    }
}
