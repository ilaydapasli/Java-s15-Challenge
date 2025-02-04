package models;

import java.util.Date;

public class Journals extends Book{
    private String publisher;

    public Journals(int bookID, String title, String author, String category, String edition, Date dateOfPurchase, String publisher) {
        super(bookID, title, author, category, edition, dateOfPurchase);
        this.publisher=publisher;
    }
    public String getPublisher(){
        return  publisher;
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Yayıncı: " + publisher);
    }
}
