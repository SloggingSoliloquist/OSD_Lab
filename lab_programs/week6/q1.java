import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
class HotelRoom{
    File file;
    public HotelRoom(File file) {
        this.file = file;
    }
    
    public void add_record(int rno, String type, double price, boolean status)
    {
        try{
            RandomAccessFile raf= new RandomAccessFile(file, "rw");
            long file_end = raf.length();
            raf.seek(file_end);
            raf.writeInt(rno); //4 bytes
            raf.writeUTF(String.format("%-20s", type)); //22 for some reason. perhaps the BOM of 2 bytes along with the 1 byte per character. Not sure. 
            raf.writeDouble(price); //8
            raf.writeBoolean(status); //1
            //so each record is 35 bytes
            raf.close();
        }
        catch(IOException e)
        {
            System.out.println("Exception: "+e);
        }
    }

    public void read_all_records()
    {
        try {
            RandomAccessFile raf= new RandomAccessFile(file, "r");
            long len= raf.length();
            System.out.println("file length: "+len);
            raf.seek(0);
            for(int i=0; i<len/35;i++)
        {
            System.out.println("===============");
            System.out.println("Room number: "+raf.readInt());

            System.out.print(raf.readUTF()); //understand how this is somehow able to read exactly the 20 characters you inputted without needing to specify number of bytes
        System.out.println("Room price: "+raf.readDouble());
        System.out.println("Room type: "+raf.readBoolean());
        }
        System.out.println("===============");
        raf.close();
        } catch (IOException e) {
            System.out.println("Error: "+e);
        }
    }
    public void read_record(int rec_no)
    {
        try {
            RandomAccessFile raf= new RandomAccessFile(file, "r");
            long len= raf.length();
            System.out.println("file length: "+len);
            raf.seek((rec_no-1)*35);
            System.out.println("=========");
            System.out.println("Room number: "+raf.readInt());
            System.out.print(raf.readUTF()); //understand how this is somehow able to read exactly the 20 characters you inputted without needing to specify number of bytes
        System.out.println("Room price: "+raf.readDouble());
        System.out.println("Room type: "+raf.readBoolean());
        System.out.println("=========");
        raf.close();
        } catch (IOException e) {
            System.out.println("Error: "+e);
        }
    }

    public boolean modify_availability(int rec_no, boolean availability)
    {
        try {
            RandomAccessFile raf= new RandomAccessFile(file, "rw");
            raf.seek((rec_no)*35-1); //35 is the size of a record
            if (raf.readBoolean()==availability)
            {
                raf.close();
                return false;
            }
            raf.seek(raf.getFilePointer()-1);
            raf.writeBoolean(availability);
            raf.close();
        } catch (IOException e) {
            System.out.println("Error modifying availability: e"+e);
        }
        return true;
    }

    public void bookRoom(int room_no)
    {
        try {
            RandomAccessFile raf= new RandomAccessFile(file, "rw");
            long len = raf.length();
            if(room_no>len/35)
            {
                System.out.println("The room number does not exist");
            }
            else if(!modify_availability(room_no, true))
            {
                System.out.println("Room already booked");
            }
            else{
                modify_availability(room_no, true);
                System.out.println("Room number "+room_no+" booked");
            }
            raf.close();
        } catch (IOException e) {
            System.out.println("Exception while modifying: "+e);
        }
    }

    public void VacateRoom(int room_no)
    {
        try {
            RandomAccessFile raf= new RandomAccessFile(file, "rw");
            long len = raf.length();
            if(room_no>len/35)
            {
                System.out.println("The room number does not exist");
            }
            else if(!modify_availability(room_no, false))
            {
                System.out.println("Room already empty");
            }
            else{
                modify_availability(room_no, false);
                System.out.println("Room number "+room_no+" vacated");
            }
            raf.close();
        } catch (IOException e) {
            System.out.println("Exception while modifying: "+e);
        }
    }
}

public class q1 {
    public static void main(String[] args){
    File file= new File("./hotel_data.txt");
    try{
    HotelRoom room = new HotelRoom(file);
    room.add_record(1, "deluxe", 25000.00, false);
    room.add_record(2, "normal", 50000.00, false);
    room.add_record(3, "deluxe", 25000.00, false);
    room.add_record(4, "suite", 50000.00, false);
    room.add_record(5, "deluxe", 25000.00, false);
    room.add_record(6, "normal", 50000.00, false);
    room.read_all_records();

    room.bookRoom(1);
    room.read_record(1);

    room.bookRoom(2);
    room.read_record(2);

    room.bookRoom(1);
    room.read_record(1);

    room.VacateRoom(1);
    room.read_record(1);
    
    room.bookRoom(1);
    room.read_record(1);

    }
    catch(Exception e)
    {
        System.out.println("exception: "+e);
    }
}
}
