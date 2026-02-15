enum HotelRoom{

    Standard(2000),
    Deluxe(3500),
    Suite(5000);
    private double daily_tariff;
    HotelRoom(double daily_tariff)
    {
        this.daily_tariff= daily_tariff;
    }

    public double get_daily_tariff()
    {
        return daily_tariff;
    }

    public double get_total_bill(int num_nights)
    {
        return daily_tariff*num_nights;
    }
}

public class q2 {
    public static void main(String[] args) {
        HotelRoom standard = HotelRoom.Standard;
        System.out.println("Standard Room details: ");
        System.out.println("Daily Tariff: "+standard.get_daily_tariff());
        System.out.println("Number of Nights: "+5);
        System.out.println("Total bill: "+standard.get_total_bill(5));

        HotelRoom deluxe= HotelRoom.Deluxe;
        System.out.println("Deluxe Room details: ");
        System.out.println("Daily Tariff: "+deluxe.get_daily_tariff());
        System.out.println("Number of Nights: "+5);
        System.out.println("Total bill: "+deluxe.get_total_bill(5));    

        HotelRoom suite= HotelRoom.Suite;
        System.out.println("Suite details: ");
        System.out.println("Daily Tariff: "+suite.get_daily_tariff());
        System.out.println("Number of Nights: "+5);
        System.out.println("Total bill: "+suite.get_total_bill(5));    
    }
}
