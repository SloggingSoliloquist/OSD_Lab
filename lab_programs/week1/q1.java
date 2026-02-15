class Book{
    private int ID;
    private String title;
    private String author;
    private double price;
    private boolean availability_status;

    public void set_ID(int ID)
    {
        this.ID= ID;
    }

    public void set_title(String title)
    {
        this.title = title;
    }

    public void set_author(String author)
    {
        this.author = author;
    }

    public void set_price(double price)
    {
        if(price>=0)
        this.price = price;
        else
        {
            System.out.println("Invalid Price");
        }
    }

    public void set_availability(boolean availability_status)
    {
        this.availability_status= availability_status;
    }
    //getters
    public int get_ID()
    {
        return ID;
    }

    public String get_title()
    {
        return title;
    }
    
    public String get_author()
    {
        return author;
    }

    public double get_price()
    {
        return price;
    }
    public Boolean get_availability_status()
    {
        return availability_status;
    }


}

public class q1 {
    public static void main(String[] args) {
        Book book = new Book();

        book.set_ID(123890);
        book.set_author("Tushar A D Rao");
        book.set_title("How to get Good at JAVA");
        book.set_price(4500.234);
        book.set_availability(false);

        System.out.println("Book Details:");
        System.out.println("Book ID:"+book.get_ID());
        System.out.println("Book Author:"+book.get_author());
        System.out.println("Book Title:"+book.get_author());
        System.out.println("Book Price:"+book.get_price());
        System.out.println("Book Availability:"+book.get_availability_status());
    }
    
}
