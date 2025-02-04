package models;

import java.util.Date;

public class Book {
    private int bookID;
    private String title;
    private String author;
    private String category;
    private String edition;
    private Date dateOfPurchase;
    private boolean isAvailable;
    private String owner; // Kitabı alan kişinin adı

    public Book(int bookID, String title, String author, String category, String edition, Date dateOfPurchase) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.category = category;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.isAvailable = true;
        this.owner = null; // Başlangıçta ödünç alınmamış
    }

    public String getAuthor() {
        return author;
    }

    public String getEdition() {
        return edition;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public String getOwner() {
        return owner;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void updateStatus(boolean status, String ownerName) {
        this.isAvailable = status;
        this.owner = status ? null : ownerName;
    }

    public void display() {
        System.out.println("Kitap Adı: " + title + " | Yazar: " + author + " | Durum: " +
                (isAvailable ? "Müsait" : "Ödünç Alındı, Sahibi: " + owner));
    }

    public String getCategory() {
        return category;
    }
}
