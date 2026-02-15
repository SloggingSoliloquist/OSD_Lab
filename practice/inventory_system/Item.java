public abstract class Item{
    protected String name;
    protected int quantity;
    //since those are private you can only access using getter methods

    public Item(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }
    public int getQuantity(){
        return quantity;
    }

    public abstract void displayInfo();
}
