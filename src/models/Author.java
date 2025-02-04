package models;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person{
    private List<Book> books;

    public Author(String name, int id) {
        super(name, id);
        this.books=new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);

    }
    public void showBooks() {
        System.out.println(getName() + " tarafından yazılan kitaplar:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle());
        }
    }

}
