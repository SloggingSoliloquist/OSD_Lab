Why multithreading? 
When a thread is taking time, the time can be used to perform some other task.

Idle CPU time can be put to good use. 

A threa dis just an independent sequential path of execution within a program. 


User thread vs daemon thread: 
There is a preference given to user threads (including main). If there is no 
user thread running, the program stops regardless of whether any daemon threads are running or not. 
When the main thread stops executing, the program will still be alive if any other user thread is still running. 

create daemon thread:
create a thread and do thread.setDaemon(true)
Daemon threads exists only to serve the parent user thread. On the completion of every user thread, the daemon thread isn't allowed to execute further and the program stops. 

Thread.currentThread() returns info about the currently executing thread. 
Note that this is called in a static manner. 
It returns a list ['Thread name', thread_priority, 'Parent Thread Name']

visibility of void run():
Java does not allow you to reduce the visibility of inherited or abstract methods. run() is defined as public in both the Thread class and the runnable interface. 

Java access restrictions: 
private<default<protected<public

When a class implements the runnable interface, the name cannot be set in the constructor like super(threadname). 
This is because a class implementing the runnable interface isn't inheriting anything, it's just implementing an interface. The name can be passed while creating the Thread from the runnable interface. 

Thread class implements Runnable as well (????)

The Thread class implements Runnable, and the code there is something like

public void run()
{
    if(target !=null)
    {
        target.run()
    }
}

so you could do (new Thread()).run() as well, but it wouldn't do anything. 
that is because the target is null. 
For the target to not be null, you must pass an instance of a class that implements Runnable. When that is passed, target.run() is executed, and this run() is the same run() that you override in the class that implements Runnable. 

If you do not want to create a runnable object and then pass that to the Thread class, you can just extend the Thread class, override its run() method
and implement your own. That is the second way of creating threads. 

So which one to pick? 
If you want to extend the Thread class, you cannot extend any other class in addition, cos that would be multiple inheritance which JAVA Does not support. 
Instead you can have the class implement Runnable alongside any other classes to implement or inherit from. So the Runnable interface really is the superior way in most cases.  