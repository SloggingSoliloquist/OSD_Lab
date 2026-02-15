public class Main {
    public static void main(String[] args){
    Inventory inventory= new Inventory();
    Fruit item3 = new Fruit("Apple", 2, "Red thing");
    Weapon item4 = new Weapon("Sword", 1, 100, "Stabby thing");
    inventory.addItem(item3);
    inventory.addItem(item4);
    inventory.displayINventory();
    String oh_no_it_expired= item3.displayActiononExpiry();
    System.out.println(oh_no_it_expired);
}
}
