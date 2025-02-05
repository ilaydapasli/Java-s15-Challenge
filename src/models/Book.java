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
    private String owner; // Kitabı ödünç alan kişi

    public Book(int bookID, String title, String author, String category, String edition, Date dateOfPurchase) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.category = category;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.isAvailable = true; // Varsayılan olarak kitap müsait
        this.owner = null;
    }

    // ✅ Getter Metotları
    public int getBookID() { return bookID; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public String getEdition() { return edition; }
    public boolean isAvailable() { return isAvailable; }
    public String getOwner() { return owner; }

    // ✅ Setter Metotları (Kitap bilgilerini güncelleme için)
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setCategory(String category) { this.category = category; }
    public void setEdition(String edition) { this.edition = edition; }

    // ✅ Kitap ödünç alma / iade durumu güncelleme
    public void updateStatus(boolean status, String ownerName) {
        this.isAvailable = status;
        this.owner = status ? null : ownerName;
    }

    // ✅ Kitap bilgilerini gösterme
    public void display() {
        System.out.println("📖 Kitap ID: " + bookID);
        System.out.println("   Başlık: " + title);
        System.out.println("   Yazar: " + author);
        System.out.println("   Kategori: " + category);
        System.out.println("   Baskı: " + edition);
        System.out.println("   Satın Alma Tarihi: " + dateOfPurchase);
        System.out.println("   Durum: " + (isAvailable ? "Müsait" : "Ödünç Alındı, Sahibi: " + owner));
        System.out.println("--------------------------------------------------");
    }
}
