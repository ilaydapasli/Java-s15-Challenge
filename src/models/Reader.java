package models;

import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String name;
    private int readerID;
    private List<Book> borrowedBooks;
    private double balance; // Kullanıcının borcu

    public Reader(String name, int readerID) {
        this.name = name;
        this.readerID = readerID;
        this.borrowedBooks = new ArrayList<>();
        this.balance = 0.0;
    }

    public String getName() { return name; }
    public int getReaderID() { return readerID; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
    public double getBalance() { return balance; }

    // ✅ Kitap ödünç alma
    public void borrowBook(Book book, double price) {
        if (borrowedBooks.size() < 5) {
            borrowedBooks.add(book);
            balance += price; // Kullanıcının borcuna ekleme yap
            book.updateStatus(false, name); // Kitap artık ödünç alınmış
            System.out.println("📖 " + name + " kitabı ödünç aldı: " + book.getTitle() + " - Ücret: " + price + " TL");
        } else {
            System.out.println("⚠ " + name + " en fazla 5 kitap ödünç alabilir!");
        }
    }

    // ✅ Kitap iade etme
    public void returnBook(Book book, double refund) {
        if (borrowedBooks.remove(book)) {
            balance -= refund; // Kullanıcının borcundan düş
            book.updateStatus(true, null); // Kitap artık müsait
            System.out.println("📖 " + name + " kitabı iade etti: " + book.getTitle() + " - Ücret İadesi: " + refund + " TL");
        } else {
            System.out.println("⚠ Kullanıcı bu kitabı ödünç almamış!");
        }
    }

    // Kullanıcı bilgilerini gösterme
    public void showInfo() {
        System.out.println("👤 Okuyucu: " + name + " | ID: " + readerID);
        System.out.println("📚 Ödünç Alınan Kitaplar:");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }
        System.out.println("💰 Kullanıcı Borcu: " + balance + " TL");
    }
}
