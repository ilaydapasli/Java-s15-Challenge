package models;
import java.util.Date;

public class StudyBooks extends Book {
    private String subject;

    public StudyBooks(int bookID, String title, String author, String category, String edition, Date dateOfPurchase, String subject) {
        super(bookID, title, author, category, edition, dateOfPurchase);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Ders: " + subject);
    }
}