public class Stack {
    private int[] array;
    private int top;

    public Stack(int capacity)
    {
        array = new int[capacity];
        top=-1;
    }

    public boolean isEmpty()
    {
        return top<0;
    }

    public boolean isFull()
    {
        return top>=array.length-1;
    }

    synchronized public boolean push(int element)
    {
        if(isFull())
        {
            return false;
        }
        ++top;
        try{
            //simulate processing time
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
        }
        array[top]=element;
        return true;
    }

    synchronized public int pop()
    {
        if(isEmpty())
        {
            return Integer.MIN_VALUE;
        }
        int obj= array[top];
        array[top]=Integer.MIN_VALUE;
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){}
        top--;
        return obj;
    }
}
