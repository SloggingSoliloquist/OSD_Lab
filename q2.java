

class Room{
    protected  int room_no;
    protected String room_type;
    protected double base_price;

    Room(int room_no, String room_type, double base_price)
    {
        this.room_no= room_no;
        this.room_type = room_type; 
        this.base_price  = base_price;
    }

    Room(int room_no, String room_type)
    {
        this.room_no= room_no;
        this.room_type = room_type; 
    }

    int display_room_no()
    {
        return room_no;
    }

    String display_room_type()
    {
        return room_type;
    }

    double display_price()
    {
        return base_price;
    }
}

class Deluxe_Room extends Room{
    private boolean free_wifi;
    private String compl_breakfast;
    private double additional_price;

    public Deluxe_Room(int room_no, String room_type, double base_price, double additional_price,String compl_breakfast, boolean free_wifi ) {
        super(room_no, room_type, base_price);
        this.free_wifi = free_wifi;
        this.compl_breakfast= compl_breakfast;
        this.additional_price= additional_price;
    }

    @Override
    double display_price()
    {
        return base_price+additional_price;
    }

    void display_base_room_details()
    {
        System.out.println("Room No: "+super.display_room_no());
        System.out.println("Room Type: "+super.display_room_type());
        System.out.println("Base Price: "+super.display_price());
    }
    boolean display_free_wifi()
    {
        return free_wifi;
    }

    String display_compl_breakfast()
    {
        return compl_breakfast;
    }

    double display_additional_price()
    {
        return additional_price;
    }
}
public class q2 {
    public static void main(String args[]){
    System.out.println("Normal Room: ");
    Room base_room = new Room(128, "Ground Floor", 16700);
    System.out.println("Price: "+base_room.display_price());
    System.out.println("Room Number: "+base_room.display_room_no());
    System.out.println("Room Type: "+base_room.display_room_type());
    System.out.println("\nDeluxe Room: ");
    Room room = new Deluxe_Room(1239, "Ocean_View", 16700, 8900, "Idli Sambhar", true);
    if(room instanceof Deluxe_Room)
    {
        Deluxe_Room deluxe_room = (Deluxe_Room) room;
        deluxe_room.display_base_room_details();
        System.out.println("Additional Price: "+deluxe_room.display_additional_price());
        System.out.println("Complimentary Breakfast: "+deluxe_room.display_compl_breakfast());
        System.out.println("Free Wifi: "+deluxe_room.display_free_wifi());
        System.out.println("Total Price: "+deluxe_room.display_price());
    }
}
}
