public class Fruit extends Item implements Transport{
    private String type;
    
    public Fruit(String name, int quantity, String type)
    {
        super(name,quantity);
        this.type=type;
    }    

    public String getType()
    {
        return type;
    }

    public void displayInfo()
    {
        System.out.println("Name: "+name+" Quantity: "+quantity+" Type: "+type);
    }

    public String displayActiononExpiry()
    {
        return "Dispose of the item in wet waste";

    }

    public int setExpTime()
    {
        return 5;
    }
} 
