package models;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Reader> readers;

    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);
        System.out.println("Kitap eklendi: "+ book.getTitle());
    }
    public Book findBookById(int bookID){
        for (Book book:books){
            if (book.getBookID()==bookID){
                return book;
            }
        }return null;
    }
    public void removeBook(int bookID){
        books.removeIf(book -> book.getBookID()==bookID);
        System.out.println("Kitap kaldırıldı(ID: " +bookID+")");
    }
    public void listBooksByCategory(String category){
        System.out.println(category + " kategorisindeki kitaplar: ");
        for (Book book:books){
            if (book.getCategory().equalsIgnoreCase(category)){
            book.display();
            }
        }
    }
    public void listBooksByAuthor(String author){
        System.out.println(author + " tarafından yazılan kitaplar: ");
        for (Book book:books){
            if (book.getAuthor().equalsIgnoreCase(author)){
                book.display();
            }
        }
    }

}
