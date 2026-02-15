
class Room{
    protected int room_no;
    protected double base_tariff;

    Room(int room_no, double base_tariff)
    {
        this.room_no = room_no;
        this.base_tariff= base_tariff;
    }

    double calculate_tariff()
    {
        return base_tariff;
    }

    double get_room_no()
    {
        return room_no;
    }
}

class Standard_Room extends Room{
    double ac_charge;
    double pantry_charge;

    public Standard_Room(int room_no, double base_tariff, double ac_charge, double pantry_charge) {
        super(room_no, base_tariff);
        this.ac_charge= ac_charge;
        this.pantry_charge= pantry_charge;
    }

    @Override
    double calculate_tariff()
    {
        return super.base_tariff+ac_charge+pantry_charge;
    }

    double get_ac_charge()
    {
        return ac_charge;
    }
    
    double pantry_charge()
    {
        return pantry_charge;
    }

    void display_standard_room_details()
    {
        System.out.println("Room No: "+super.get_room_no());
        System.out.println("Base Tariff: "+super.base_tariff);
        System.out.println("Ac Charge: "+ac_charge);
        System.out.println("Pantry Charge: "+pantry_charge);
    }
}

class Luxury_Room extends Room{
    double ac_charge;
    double pantry_charge;
    double sauna_charge;
    double pool_table_charge;

    public Luxury_Room(int room_no, double base_tariff, double ac_charge, double pantry_charge, double sauna_charge, double pool_table_charge) {
        super(room_no, base_tariff);
        this.ac_charge= ac_charge;
        this.pantry_charge= pantry_charge;
        this.sauna_charge= sauna_charge;
        this.pool_table_charge= pool_table_charge;
    }

    @Override
    double calculate_tariff()
    {
        return super.base_tariff+ac_charge+pantry_charge+sauna_charge+pool_table_charge;
    }

    double get_ac_charge()
    {
        return ac_charge;
    }
    
    double pantry_charge()
    {
        return pantry_charge;
    }

    double get_sauna_charge()
    {
        return pantry_charge;
    }
    
    double get_pool_table_charge()
    {
        return pool_table_charge;
    }

    void display_luxury_room_details()
    {
        System.out.println("Room No: "+super.get_room_no());
        System.out.println("Base Tariff: "+super.base_tariff);
        System.out.println("AC Charge: "+ac_charge);
        System.out.println("Pantry Charge: "+pantry_charge);
        System.out.println("Sauna Charge: "+sauna_charge);
        System.out.println("Pool Table Charge: "+pool_table_charge);
    }
}

public class q3 {
    public static void main(String[] args) {
        Room standard_room = new Standard_Room(100, 4000, 700, 400);
        double standard_room_tariff = standard_room.calculate_tariff();
        
        Room luxury_room = new Luxury_Room(200,4000, 1000,500, 1000, 800);
        double luxury_room_tariff = luxury_room.calculate_tariff();

        System.out.println("Standard Room: ");
        if(standard_room instanceof Standard_Room)
        {
            Standard_Room s_room = (Standard_Room) standard_room;
            s_room.display_standard_room_details();
        }
        System.out.println("Standard Room Tariff: "+standard_room_tariff);

        System.out.println("\nLuxury Room: ");
        if(luxury_room instanceof Luxury_Room)
        {
            Luxury_Room l_room  = (Luxury_Room) luxury_room;
            l_room.display_luxury_room_details();
        }
        System.out.println("Luxury Room Tariff: "+luxury_room_tariff);
    }
}
