public class Weapon extends Item{
    private int damage;
    private String type;

    public Weapon(String name, int quantity, int damage, String type)
    {
        super(name, quantity);
        this.damage = damage;
        this.type=type;
    }

    public int getDamage()
    {
        return damage;
    }

    public String getType()
    {
        return type;
    }

    public void displayInfo()
    {
        System.out.println("Name: "+name+" Quantity: "+quantity+" Type: "+type+" Damage: "+damage);
    }
}
