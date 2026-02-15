class Order_Validation implements Runnable{

    String order_id;
    Order_Validation(String order_id) {
        this.order_id= order_id;
    }
    public void run()
    {
        try {
            for(int i=5; i>0; i--)
            {
                System.out.println("Time left for Order Validation "+order_id+": "+i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread failed on exception");
        }
    }    
}

class Payment_Processing implements Runnable{
    String order_id;
    Thread t;
    Payment_Processing(String order_id){
        t = new Thread(this, order_id);
    }

    public void run()
    {
        try {
            for(int i=10; i>0; i--)
            {
                System.out.println("Time left for processing payment of order "+t.getName()+": "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread failed on exception");
        }
    }
}

class Order_Shipment extends Thread{
    String order_id;
    Order_Shipment(String order_id){
        super("Order Shipment");
        this.order_id= order_id;
    }


    public void run()
    {
        try {
            for(int i=10; i>0; i--)
            {
                System.out.println("Steps left for shipment of order "+order_id+": "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread failed on exception");
        }
    }
}

public class q2 {
    
    public static void main(String[] args) {

        Order_Validation order1 = new Order_Validation("1");
        Thread order_val_thread1 = new Thread(order1);
        Payment_Processing payment1 = new Payment_Processing("1");
        Order_Shipment order_shipment_thread1 = new Order_Shipment("1");

        Order_Validation order2 = new Order_Validation("3");
        Thread order_val_thread2 = new Thread(order2);
        Payment_Processing payment2= new Payment_Processing("3");
        Order_Shipment order_shipment_thread2 = new Order_Shipment("3");

        Order_Validation order3 = new Order_Validation("2");
        Thread order_val_thread3 = new Thread(order3);
        Payment_Processing payment3 = new Payment_Processing("2");
        Order_Shipment order_shipment_thread3 = new Order_Shipment("2");

        order_val_thread1.start();
        order_val_thread2.start();
        order_val_thread3.start();
        try {
            order_val_thread1.join();
            order_val_thread2.join();
            order_val_thread3.join();
        } catch (Exception e) {
            System.out.println("Exception");
        }

        payment1.t.start();
        payment2.t.start();
        payment3.t.start();
        try {
            payment1.t.join();
            payment2.t.join();
            payment3.t.join();
        } catch (Exception e) {
            System.out.println("Exception");
        }
        order_shipment_thread1.start();
        order_shipment_thread2.start();
        order_shipment_thread3.start();



    }
}
