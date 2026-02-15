
//operation on the same resource by another thread, hence requiring communication between the two threads

class Restaurant{ //This is a table at a restaurant
    private int[] table_nos={1, 2, 3, 4, 5};
    //Tables can be booked concurrently but only available tables, if any, must be allotted
    private boolean[] occupied = new boolean[5];
    synchronized public void BookTable(int table_no)
    {
        boolean found = false;
        int available_idx=0;
        for(int i=0; i<5; i++)
        {
            if(occupied[i]==false)
            {
                found=true;
                available_idx=i;
                break;
            }
        }
        while (!found) { 
            try{
            wait(); //if a table is not available, wait for one to be allotted. 
            }
            catch(InterruptedException e)
            {
                System.out.println("Error in waiting");
            }
        }

        System.out.println("Alloting thread "+Thread.currentThread().getName()+" table no "+table_nos[available_idx]);
        occupied[available_idx]=true;
        notify();
    }

    synchronized public void leave_table(int table_no)
    {
        boolean all_tables_free=true;
        for(int i=0; i<5;i++)
        {
            if(occupied[i]==true)
            {
                all_tables_free=false;
                break;
            }
        }
        while(all_tables_free)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Waiting failed");
            }
        }

        occupied[table_no-1]=false;
        System.out.println("Table no. "+table_no+" is now free");
        notify();
    }
}

class BookTable extends Thread{
    private int table_no;
    Restaurant table;
    public BookTable(String threadname, int table_no, Restaurant table) {
        super(threadname);
        this.table_no=table_no;
        this.table= table;
    }

    @Override
    public void run()
    {
        System.out.println("Requesting Booking on table "+table_no);
        table.BookTable(table_no);
        try {
            sleep(5000);
        } catch (Exception e) {
            System.out.println("Failed");
        }
    }
}

class LeaveTable extends Thread{
    private int table_no;
    Restaurant table;
    public LeaveTable(String threadname, int table_no, Restaurant table) {
        super(threadname);
        this.table_no=table_no;
        this.table= table;
    }

    @Override
    public void run()
    {
        System.out.println("Leaving table "+table_no);
        table.leave_table(table_no);
        try {
            sleep(5000);
        } catch (Exception e) {
            System.out.println("Failed");
        }
    }
}
public class waiting_and_notifying {
    public static void main(String[] args) {
        //create an object of the shared resource (Restaurant)
        Restaurant table = new Restaurant();
        //create multiple booking and leaving threads
        BookTable cust1 = new BookTable("Customer 1", 1, table);
        BookTable cust2 = new BookTable("Customer 2", 2, table);
        BookTable cust3 = new BookTable("Customer 3", 3, table);
        BookTable cust4 = new BookTable("Customer 4", 3, table);
        BookTable cust5 = new BookTable("Customer 5", 1, table);

        LeaveTable leave1 = new LeaveTable("Leaver 1", 1, table);
        LeaveTable leave2 = new LeaveTable("Leaver 2", 2, table);
        LeaveTable leave3 = new LeaveTable("Leaver 3", 3, table);
        LeaveTable leave4 = new LeaveTable("Leaver 4", 1, table);
        LeaveTable leave5 = new LeaveTable("Leaver 5", 3, table);

        cust1.start();
        cust2.start();
        cust3.start();
        cust4.start();
        leave1.start();
        leave3.start();
        cust5.start();



    }
    
}
