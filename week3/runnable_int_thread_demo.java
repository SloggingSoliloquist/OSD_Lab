//here a child thread is created using the Runnable interface and the main thread is also run at the same time. Not the asynchronous nature

class NewThread implements Runnable   //create a class that implements the abstract interface Runnable
{
    Thread t; 
    NewThread()
    {
        t = new Thread(this, "New Thread");//create the actual thread inside the constructor
        System.out.println("Started thread: "+t);
        t.start();  //start() method invokes the run() method implicitly
    }

    public void run()  //put the code that actually has to be run over here. this will be called by the t.start() method. Since t.start() is in the constructor, the contents
    //here will be executed whenever an instance of this NewThread class is created
    {
        try{
            for(int i = 5; i>0; i--)
            {
                System.out.println("i: "+i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Failed thread execution");
        }
    }
}




public class runnable_int_thread_demo {
    public static void main(String[] args) {
            
    NewThread newthread = new NewThread(); //create an instance of the NewThread class. This is also termed the runnable object. Note that the constructor will run, which means the contents of the run() method
    //inside the NewThread() class will be called implicitly
    newthread.t.setName("Thread using Runnable interface"); //remember that t is the actual thread created inside NewThread. newthread is the runnable object, and t is the thread

    //create the main thread and run it:
    Thread mainthread = Thread.currentThread();
    mainthread.setName("Main Thread");
    try{
    for(int i=5; i>0; i--)
    {
        System.out.println("Main thread i: "+i);
        Thread.sleep(2000);
    }
}
catch(InterruptedException e)
{
    System.out.println("Main thread was interrupted");
}

    }
}
