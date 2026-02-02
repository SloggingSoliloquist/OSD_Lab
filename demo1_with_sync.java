//Just have a class for some shared resource and have multipl threads rying to access that shared resource

class CookiesSync{ //Distribute a maximum of 100 cookies per person. This is the shared resource
    private int max_cookies = 100;
    //Make take_cookies() a synchronized method
    synchronized public void take_cookies(int num_cookies)
    {

        System.out.println("The Thread "+Thread.currentThread().getName()+" is requesting "+num_cookies+" cookies");
        if(num_cookies<max_cookies)
        {
            try{
            System.out.println("Taking 2 seconds to give all of "+Thread.currentThread().getName()+"s cookies");
            Thread.sleep(2000);
            max_cookies-=num_cookies;
        }
            catch(InterruptedException e){
                System.out.println("The process failed");
            }
        }
        else
        {
            System.out.println(Thread.currentThread().getName()+" cannot withdraw these many cookies");
        }
    }
}

class CookieEater extends Thread{
    private int num_cookies;
    private CookiesSync eater;
    CookieEater(String name,int num_cookies, CookiesSync eater){  //pass an object of the Cookies class here so that this thread can call the take_cookies() method of that class and take cookies
        super(name);
        this.num_cookies = num_cookies;
        this.eater = eater;
    }

    @Override
    public void run()
    {
        eater.take_cookies(num_cookies);
    }
}

class demo1_with_sync{
    public static void main(String[] args) {
        //now create a SINGLE object of Cookies and multiple Eater threads to take cookies from the pool of 100 cookies
        CookiesSync cookie_distribution = new CookiesSync();
        //Now create multiple threads (eaters) and pass the same cookie_distribution object of the cookies class to all the threads
        CookieEater eater1 = new CookieEater("Cookie_Eater1", 30, cookie_distribution);
        CookieEater eater2 = new CookieEater("Cookie_Eater2", 40, cookie_distribution);
        CookieEater eater3 = new CookieEater("Cookie_Eater3", 50, cookie_distribution);

        //now unlike the version of this without sync, all of these threads will lock, execute and release the shared resource that is CookiesSync
        //one by one, and eater3 will be unable to withdraw his cookies. 

        eater1.start();
        eater2.start();
        eater3.start();
    }
}
