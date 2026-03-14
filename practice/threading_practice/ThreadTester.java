public class ThreadTester{
    public static void main(String[] args)
    {
        System.out.println("main thread starts");
        Thread thread1= new Thread1("User thread");
        Thread thread2= new Thread(new Thread2(), "hi");
        thread1.start();
        thread2.start();
        System.out.println("Main thread ends");
    }
}