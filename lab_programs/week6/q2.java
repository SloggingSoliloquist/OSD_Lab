import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
class Room implements Serializable{
    int rno;
    String type;
    double price;
    boolean status;
    String guest_name;

    public Room(int rno, String type, double price, boolean status, String guest_name)
    {
        this.rno= rno;
        this.type = type;
        this.price= price;
        this.status= status;
        this.guest_name= guest_name;
    }
}

class RoomOperations{
    int 
}
public class q2 {
    public static void main(String[] args) {
        
    Room room1= new Room(1, "normal", 25000.0, false, "tushar");
    Room room2 = new Room(2, "deluxe", 50000.0, false, "eshaan");
    Room room3 = new Room(3, "normal", 25000.0, false, "zil");
    Room room4 = new Room(4, "normal", 25000.0, false, "pragati");
    try{
    FileOutputStream fos = new FileOutputStream("hotel.dat");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(room1);
    oos.writeObject(room2);
    oos.writeObject(room3);
    oos.writeObject(room4);
    oos.close();
    fos.close();

    }
    catch(IOException e)
    {
        System.out.println("Error while serializing: "+e);
    }
}
}
