import java.util.LinkedList;
import java.util.Queue;

class queue{
    Queue<Integer> objects;


    queue(){
        objects= new LinkedList<>();
    }

    synchronized public boolean addItem(int item)
    {
        while(objects.size()==5) //cannot add more when queue is full
        {
            try{
            wait();}
            catch(InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }

        objects.add(item);
        notify();
        return true;
    }

    synchronized public int removeItem()
    {
        while(objects.size()==0) //cannot remove when queue is empty
        {
            try{
            wait();
            }
            catch(InterruptedException  e)
            {
                Thread.currentThread().interrupt();
            }
        }

        int first=objects.peek();
        objects.remove();
        notifyAll();
        return first;
    }
}

class Producer implements Runnable{
    queue q;
    int el;
    public Producer(queue q, int el)
    {
        this.q=q;
        this.el=el;
    }

    @Override
    public void run()
    {
        q.addItem(el);
        try{
        Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {

        }
    }
}

class Consumer implements Runnable{
    queue q;
    int el;
    public Consumer(queue q)
    {
        this.q=q;
    }

    @Override
    public void run()
    {
        System.out.println("Removed: "+q.removeItem());
        try{
        Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {

        }
    }
}

public class prod_con_q
{
    queue q = new queue();
    Thread prod_thread = new Thread(new Producer(q, 10));
    Thread cons_thread = new Thread(new Consumer(q));
    prod_thread.start();
    cons_thread.start();
}
