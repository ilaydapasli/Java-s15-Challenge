package models;

import java.util.*;

public class Library {
    private List<Book> books;
    private List<Reader> readers;
    private Map<String, Double> invoices; // Kullanıcı borçları

    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.invoices = new HashMap<>();
    }

    // ✅ Kitap ekleme
    public void addBook(Book book) {
        books.add(book);
        System.out.println("📚 Kitap eklendi: " + book.getTitle());
    }

    // ✅ Okuyucu ekleme
    public void addReader(Reader reader) {
        readers.add(reader);
        System.out.println("👤 Okuyucu eklendi: " + reader.getName());
    }

    // ✅ Tüm kitapları döndüren metot
    public List<Book> getBooks() {
        return books;
    }

    // ✅ Kitap ID'ye göre bulma
    public Book findBookById(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null;
    }

    // ✅ Okuyucu adıyla bulma
    public Reader findReaderByName(String name) {
        for (Reader reader : readers) {
            if (reader.getName().equalsIgnoreCase(name)) {
                return reader;
            }
        }
        return null;
    }

    // ✅ Kitap bilgilerini güncelleme
    public void updateBookInfo(int bookID, String newTitle, String newAuthor, String newCategory, String newEdition) {
        Book book = findBookById(bookID);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setCategory(newCategory);
            book.setEdition(newEdition);
            System.out.println("📖 Kitap bilgileri güncellendi: " + newTitle);
        } else {
            System.out.println("⚠ Kitap bulunamadı!");
        }
    }

    // ✅ Kitap silme
    public void removeBook(int bookID) {
        Book book = findBookById(bookID);
        if (book != null) {
            books.remove(book);
            System.out.println("📖 Kitap kaldırıldı: " + book.getTitle());
        } else {
            System.out.println("⚠ Kitap bulunamadı!");
        }
    }

    // ✅ Tüm kitapları listeleme
    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("📚 Kütüphanede hiç kitap yok.");
        } else {
            System.out.println("📚 Kütüphanedeki Tüm Kitaplar:");
            for (Book book : books) {
                book.display();
            }
        }
    }

    // ✅ Kategoriye göre kitap listeleme
    public void listBooksByCategory(String category) {
        System.out.println("📚 " + category + " kategorisindeki kitaplar:");
        boolean found = false;
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                book.display();
                found = true;
            }//break ekle
        }
        if (!found) {
            System.out.println("⚠ Bu kategoride kitap bulunamadı.");
        }
    }

    // ✅ Yazara göre kitap listeleme
    public void listBooksByAuthor(String author) {
        System.out.println("📚 " + author + " tarafından yazılan kitaplar:");
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                book.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("⚠ Bu yazarın kitapları bulunamadı.");
        }
    }

    // ✅ Kullanıcı borcunu gösterme
    public void displayUserBalance(String readerName) {
        Reader reader = findReaderByName(readerName);
        if (reader != null) {
            System.out.println("💰 " + reader.getName() + " toplam borcu: " + reader.getBalance() + " TL");
        } else {
            System.out.println("⚠ Kullanıcı bulunamadı!");
        }
    }
}
