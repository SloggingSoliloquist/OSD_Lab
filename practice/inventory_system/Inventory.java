//Stores objects of class Item
import java.util.ArrayList;
//java.util.ArrayList is just an array that can store objects 
public class Inventory {
    private ArrayList<Item> items; //declaring the array list of items

    public Inventory()
    {
        items=new ArrayList<>(); //Actually creating the array list object
    }

    public void addItem(Item item)
    {
        items.add(item);
    }

    public void displayINventory(){
        for(Item item: items){
            item.displayInfo();
        }
    }


}
