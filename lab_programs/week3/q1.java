class RC_thread implements Runnable{
    String taskName;
    RC_thread(String taskName)
    {
        this.taskName = taskName;
    }

    @Override
    public void run()
    {
        try{

            for (int i = 0; i < 15; i++) {
                System.out.println("Steps remaining for the task "+taskName+": "+(15-i));
                if(i==7)
                {
                    System.out.println(taskName+" halfway done");
                }
                Thread.sleep(500);
            }
            System.out.println(taskName+" has been completed");
        }
        catch(InterruptedException e)
        {
            System.out.println("Task was interrupted");
        }
    }
}

class FD_thread implements Runnable{
    Thread t;
    FD_thread()
    {
        t = new Thread(this, "Food Delivery");
    }

    public void run()
    {
        try {
            for(int i=20; i>0; i--)
            {
                System.out.println("Status of "+t.getName()+": ");
                if(i>=15)
                {
                    System.out.println("Your order is being prepared");
                }
                else if(i>=10)
                {
                    System.out.println("Your delivery partner has picked up your order");
                }
                else if (i>=2)
                {
                    System.out.println("Your order is: "+i+" steps away");
                }
                else{
                    System.out.println("Your order is almost here");
                }

                Thread.sleep(500);
            }
            System.out.println("Your order has arrived");
            
        } catch (InterruptedException e) {
            System.out.println(t.getName()+ " FAILED");
        }
    }
}


class MT_thread extends Thread{
    String maintenance_task;
    MT_thread(String maintenance_task)
    {
        super("Maintenance");
        this.maintenance_task= maintenance_task;
    }

    public void run()
    {
        try{
            System.out.println("The "+this.getName() + " task is: "+maintenance_task);
            for(int i=0; i<7; i++)
            {
                System.out.println("The time remaining for "+maintenance_task+" is "+(7-i));
                Thread.sleep(2000);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("The task "+this.getName()+" was interrupted");
        }
    }
}

public class q1 {

    public static void main(String args[])
    {
        //Create the runnable object
        RC_thread room_cleaning_thread = new RC_thread("Room Cleaning");
        //create the actual thread
        Thread t1 = new Thread(room_cleaning_thread);

        //create the runnable object for the food delivery thread
        FD_thread food_delivery_thread = new FD_thread();
        Thread t3 = new MT_thread("Plumbing");
        t1.start();
        food_delivery_thread.t.start(); //Start the food delivery thread(remember that food_delivery_thread is only the runnable object and not the thread that is being run itself)
        t3.start();
    }
    
}
