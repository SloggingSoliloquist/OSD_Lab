public class StackSync {
    public static void main(String[] args){
    Stack stk= new Stack(10);
    Thread pusher= new Thread(new Pusher(stk));
    Thread popper = new Thread(new Popper(stk));
    pusher.start();
    popper.start();
}
}
 