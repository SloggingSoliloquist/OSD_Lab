public class ThreadTester{
    public static void main(String[] args)
    {
        System.out.println("main thread starts");
        Thread thread1= new Thread1("User thread");
        Thread2 thread2_run = new Thread2();
        Thread thread2= new Thread(thread2_run, "hi");
        thread1.start();
        thread2.start();
        System.out.println("Main thread ends");
    }
}