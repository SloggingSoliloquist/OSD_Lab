public class Pusher implements Runnable {
    Stack stk;
    public Pusher(Stack stk)
    {
        this.stk=stk;
    }

    @Override
    public void run()
    {
    int i=0;
    while(++i<10)
    {
        System.out.println("Pushed: "+stk.push(i));
    }
}
}
