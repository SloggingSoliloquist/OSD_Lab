
//define what objects you want the UI to actually use
public class Device{
    public String name;
    public String room;

    public Device(String name, String room){
        this.name=name;
        this.room=room;
    }
    //Need getters for tableview
    public String getName(){
        return name;
    }
    public String getRoom(){
        return room;
    }
}