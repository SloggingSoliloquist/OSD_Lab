public class Popper implements Runnable {
    Stack stk;
    public Popper(Stack stk)
    {
        this.stk=stk;
    }

    @Override
    public void run()
    {
    int i=0;
    while(++i<10)
    {
        System.out.println("Popped: "+stk.pop());
    }
}
}
