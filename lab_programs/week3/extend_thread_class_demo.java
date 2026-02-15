class ExtendedThread extends Thread{
    
    ExtendedThread()
    {
    super("Extended thread");  //The Thread Class already has all the methods we need to create the thread so we will just reference that using Super()
    }

    public void run()
    {
        System.out.println("Created a thread by extending the Thread class: ");
        try{
            for(int i=5; i>0; i--)
            {
                System.out.println("i: "+i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Exception interrrupted");
        }
    }
}


public class extend_thread_class_demo {

    public static void main(String args[])
    {
        ExtendedThread thread = new ExtendedThread();
        thread.start();
    }
    
}
