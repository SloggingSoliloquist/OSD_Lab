class Room {
    private Integer days_stayed;
    private Double tariff;
    private Double pantry_charge;
    private Double wifi_charge;
    private Double breakfast_charge;

    Room(Integer days_stayed, Double tariff, Double pantry_charge, Double wifi_charge, Double breakfast_charge) {
        this.days_stayed = days_stayed;
        this.tariff = tariff;
        this.pantry_charge = pantry_charge;
        this.wifi_charge = wifi_charge;
        this.breakfast_charge = breakfast_charge;
    }

    int get_days_stayed() {
        return days_stayed;
    }

    double get_tariff() {
        return tariff;
    }

    double get_pantry_charge() {
        return pantry_charge;
    }

    double get_wifi_charge() {
        return wifi_charge;
    }

    double get_breakfast_charge() {
        return breakfast_charge;
    }

    double calculate_tariff() {
        int prim_days_stayed = days_stayed;
        double prim_daily_tariff = tariff;
        double prim_pantry_charge = pantry_charge;
        double prim_wifi_charge = wifi_charge;
        double prim_breakfast_charge = breakfast_charge;

        return (prim_daily_tariff + prim_pantry_charge + prim_wifi_charge + prim_breakfast_charge) * prim_days_stayed;
    }
}

public class q1 {
    public static void main(String[] args) {
        int days_stayed = 5;
        double daily_tariff = 2000.2, pantry_charge = 300.3, wifi_charge = 100.2, breakfast_charge = 400.2;
        Integer days_stayed_obj = days_stayed;
        Double daily_tariff_obj = daily_tariff;
        Double pantry_charge_obj = pantry_charge;
        Double wifi_charge_obj = wifi_charge;
        Double breakfast_charge_obj = breakfast_charge;
        Room room = new Room(days_stayed_obj, daily_tariff_obj, pantry_charge_obj, wifi_charge_obj,
                breakfast_charge_obj);
        System.out.println("Customer Details: ");
        System.out.println("Days stayed: " + room.get_days_stayed());
        System.out.println("Daily Tariff: " + room.get_tariff());
        System.out.println("Pantry Charge: " + room.get_pantry_charge());
        System.out.println("Wifi charge: " + room.get_wifi_charge());
        System.out.println("Breakfast Charge: " + room.get_breakfast_charge());
        System.out.println("Total Bill: " + room.calculate_tariff());
    }
}
