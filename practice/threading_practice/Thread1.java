public class Thread1 extends Thread{
    //override the run method of the Thread class
    public Thread1(String threadname)
    {
        super(threadname);
    }
    @Override
    public void run() //put the code for the thread here
    {
        System.out.println(this.getName());
        for(int i=0; i<5; i++)
        {
            System.out.println("Inside thread: "+Thread.currentThread()+i);
        }
    }
}
