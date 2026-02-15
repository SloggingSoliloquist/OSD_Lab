class current_thread_demo{
    
//Control the main thread here

public static void main(String args[])
{
    Thread thread = Thread.currentThread(); //create a reference to the current thread. In this case the current thread is actually the main thread
    System.out.println("The current thread: "+thread);
    thread.setName("Created Thread"); //name the thread
    System.out.println("The thread name after changing: "+thread);
    try{
        for(int i =5;i>0; i--)
        {
            System.out.println("i: "+i );
            Thread.sleep(1000);
        }
    }
    catch(InterruptedException s)
    {
        System.out.println("Main thread completed");        
    }
}
    }