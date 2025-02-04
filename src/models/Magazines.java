package models;
import java.util.Date;

public class Magazines extends Book {
    private int issueNumber;

    public Magazines(int bookID, String title, String author, String category, String edition, Date dateOfPurchase, int issueNumber) {
        super(bookID, title, author, category, edition, dateOfPurchase);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Sayı Numarası: " + issueNumber);
    }
}